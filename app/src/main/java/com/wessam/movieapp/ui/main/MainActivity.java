package com.wessam.movieapp.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.google.gson.Gson;
import com.thekhaeng.pushdownanim.PushDownAnim;
import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.actor.Actor;
import com.wessam.movieapp.data.db.actor.ActorResults;
import com.wessam.movieapp.data.db.movie.Movie;
import com.wessam.movieapp.data.db.movie.MovieResults;
import com.wessam.movieapp.data.network.ApiService;
import com.wessam.movieapp.data.network.RetrofitClient;
import com.wessam.movieapp.databinding.ActivityMainBinding;
import com.wessam.movieapp.ui.main.adapter.ActorSearchAdapter;
import com.wessam.movieapp.ui.main.adapter.MovieSearchAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ArrayList<String> categoryList;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setController(MainActivity.this);

        mBinding.resultRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        PushDownAnim.setPushDownAnimTo(mBinding.searchButton);

        Paper.init(this);

        categoryList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.category_list)));

        apiService = RetrofitClient.getClient().create(ApiService.class);

        retrievePaperDB();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Integer position = Paper.book().read("position");
        if (position != null) {
            mBinding.sourceSpinner.setSelectedIndex(position);
        }
    }

    public void onSearchButtonClick() {
        mBinding.searchButton.setOnClickListener(view -> {
            if (mBinding.searchEditText.getText() != null) {
                String query = mBinding.searchEditText.getText().toString();
                if (query.isEmpty() || query.equals(" ")) {
                    Toast.makeText(this, getResources().getString(R.string.enter_valid_name), Toast.LENGTH_SHORT).show();
                } else {
                    String finalQuery = query.replaceAll(" ", "+");
                    if (categoryList.size() > 0) {
                        String categoryName = categoryList.get(mBinding.sourceSpinner.getSelectedIndex());
                        if (categoryName.equals(categoryList.get(0))) {
                            Call<Movie> movieCall = apiService.getMovieByQuery(finalQuery);

                            movieCall.enqueue(new Callback<Movie>() {
                                @Override
                                public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {
                                    Movie movie = response.body();
                                    getMoviesList(movie);
                                }

                                @Override
                                public void onFailure(@NonNull Call<Movie> call, @NonNull Throwable t) {

                                }
                            });
                        } else {
                            Call<Actor> actorCall = apiService.getActorByQuery(finalQuery);

                            actorCall.enqueue(new Callback<Actor>() {
                                @Override
                                public void onResponse(@NonNull Call<Actor> call, @NonNull Response<Actor> response) {
                                    Actor actor = response.body();
                                    getActorsList(actor);
                                }

                                @Override
                                public void onFailure(@NonNull Call<Actor> call, @NonNull Throwable t) {
                                }
                            });
                        }
                    }
                }
            }
        });
    }

    private void getActorsList(Actor actor) {
        if (actor != null) {
            List<ActorResults> actorResults = actor.getResults();
            ActorSearchAdapter actorSearchAdapter = new ActorSearchAdapter(MainActivity.this, actorResults);
            mBinding.resultRecyclerView.setAdapter(actorSearchAdapter);

            setRecyclerAnimation();

            Paper.book().write("cache", new Gson().toJson(actor));

            Paper.book().write("source", "actor");

        }
    }

    private void getMoviesList(Movie movie) {
        if (movie != null) {
            List<MovieResults> movieResults = movie.getResults();
            MovieSearchAdapter movieSearchAdapter = new MovieSearchAdapter(MainActivity.this, movieResults);
            mBinding.resultRecyclerView.setAdapter(movieSearchAdapter);

            setRecyclerAnimation();

            Paper.book().write("cache", new Gson().toJson(movie));

            //set spinner at start
            Paper.book().write("source", "movie");
        }
    }

    private void setRecyclerAnimation() {
        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_slide_right);
        mBinding.resultRecyclerView.setLayoutAnimation(animationController);
        mBinding.resultRecyclerView.scheduleLayoutAnimation();
    }

    //retrieve the result from paperDB
    private void retrievePaperDB() {
        String result = Paper.book().read("cache");
        if (result != null) {
            String source = Paper.book().read("source");
            if (source != null) {
                if (source.equals("movie")) {
                    Movie movie = new Gson().fromJson(result, Movie.class);
                    getMoviesList(movie);
                } else {
                    Actor actor = new Gson().fromJson(result, Actor.class);
                    getActorsList(actor);
                }
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (getCurrentFocus() != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null)
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Paper.book().write("position", mBinding.sourceSpinner.getSelectedIndex());
    }

}