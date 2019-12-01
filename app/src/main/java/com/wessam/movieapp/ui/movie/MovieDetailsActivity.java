package com.wessam.movieapp.ui.movie;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.credits.Cast;
import com.wessam.movieapp.data.db.credits.Crew;
import com.wessam.movieapp.data.db.credits.MovieCredits;
import com.wessam.movieapp.data.db.moviedetails.Genres;
import com.wessam.movieapp.data.db.moviedetails.MovieDetails;
import com.wessam.movieapp.data.db.moviedetails.ProductionCompanies;
import com.wessam.movieapp.data.db.moviedetails.ProductionCountries;
import com.wessam.movieapp.data.db.movieimages.MovieImages;
import com.wessam.movieapp.data.db.movieimages.MoviePostersAndBackdrops;
import com.wessam.movieapp.data.network.ApiService;
import com.wessam.movieapp.data.network.RetrofitClient;
import com.wessam.movieapp.databinding.ActivityMovieDetailsBinding;
import com.wessam.movieapp.ui.movie.adapter.MovieCreditsCastAdapter;
import com.wessam.movieapp.ui.movie.adapter.MovieCreditsCrewAdapter;
import com.wessam.movieapp.ui.movie.adapter.MovieImagesAdapter;
import com.wessam.movieapp.ui.movie.adapter.MovieProductionCompaniesAdapter;
import com.wessam.movieapp.utils.Constants;
import com.wessam.movieapp.utils.Helper;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailsActivity extends AppCompatActivity {

    private ActivityMovieDetailsBinding binding;
    private int id;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details);

        apiService = RetrofitClient.getClient().create(ApiService.class);

        binding.movieDetailCastRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.movieDetailCrewRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.movieDetailProductionCompanyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.movieDetailImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        Intent intent = getIntent();
        id = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(Constants.MOVIE_ID_KEY)));

        getMovieDetails();
        getCreditsDetails();
        getMovieImages();
    }

    private void getMovieDetails() {
        Call<MovieDetails> movieDetailsCall = apiService.getMovieDetails(id);

        movieDetailsCall.enqueue(new Callback<MovieDetails>() {
            @Override
            public void onResponse(@NonNull Call<MovieDetails> call, @NonNull Response<MovieDetails> response) {
                MovieDetails movieDetails = response.body();
                if (movieDetails != null) {
                    prepareMovieDetails(movieDetails);
                }
            }
            @Override
            public void onFailure(@NonNull Call<MovieDetails> call, @NonNull Throwable t) {
            }
        });
    }

    private void prepareMovieDetails(MovieDetails movieDetails) {
        Picasso.get().load(movieDetails.getPoster_path()).placeholder(R.drawable.logo).into(binding.movieDetailPosterImageView);
        Picasso.get().load(movieDetails.getBackdrop_path()).placeholder(R.drawable.logo).into(binding.movieDetailPosterCircleImageView);
        binding.movieDetailRatingBar.setText(String.valueOf(movieDetails.getVote_average()));
        binding.movieDetailRatingNumber.setText(Helper.formatNumber(movieDetails.getVote_count()));
        setMovieTitleAndOriginalTitle(movieDetails);
        prepareStringDetails(Helper.formatTime(movieDetails.getRuntime()), binding.movieDetailRuntime, binding.movieDetailRuntimeLayout);
        prepareStringDetails(Helper.formatNumber(movieDetails.getRevenue()), binding.movieDetailRevenue, binding.movieDetailRevenueLayout);
        prepareStringDetails(Helper.formatNumber(movieDetails.getBudget()), binding.movieDetailBudget, binding.movieDetailBudgetLayout);
        prepareStringDetails(movieDetails.getOriginal_language(), binding.movieDetailOriginalLanguage, binding.movieDetailOriginalLanguageLayout);
        prepareStringDetails(movieDetails.getOverview(), binding.movieDetailOverview, binding.movieDetailOverviewLayout);
        prepareStringDetails(movieDetails.getRelease_date(), binding.movieDetailReleaseDate, binding.movieDetailReleaseDateLayout);
        prepareStringDetails(Helper.returnStringFromBoolean(movieDetails.getAdult()), binding.movieDetailAdult, binding.movieDetailAdultLayout);
        prepareGenresListDetails(movieDetails);
        prepareProductionCountriesListDetails(movieDetails);
        prepareProductionCompaniesListDetails(movieDetails);
    }

    private void setMovieTitleAndOriginalTitle(MovieDetails movieDetails){
        if (!(movieDetails.getOriginal_title().equals(movieDetails.getTitle()))) {
            binding.movieDetailOriginalTitle.setText(movieDetails.getOriginal_title());
            binding.movieDetailOriginalTitleLayout.setVisibility(View.VISIBLE);
        }
        binding.movieDetailTitle.setText(movieDetails.getTitle());
    }

    private void getCreditsDetails() {
        Call<MovieCredits> movieCreditsCall = apiService.getMovieCredits(id);

        movieCreditsCall.enqueue(new Callback<MovieCredits>() {
            @Override
            public void onResponse(@NonNull Call<MovieCredits> call, @NonNull Response<MovieCredits> response) {
                MovieCredits movieCreditsResponse = response.body();
                if (movieCreditsResponse != null) {
                    prepareCastListDetails(movieCreditsResponse);
                    prepareCrewListDetails(movieCreditsResponse);
                }
            }
            @Override
            public void onFailure(@NonNull Call<MovieCredits> call, @NonNull Throwable t) {
            }
        });
    }

    private void getMovieImages() {
        Call<MovieImages> imagesCall = apiService.getMovieImages(id);

        imagesCall.enqueue(new Callback<MovieImages>() {
            @Override
            public void onResponse(@NonNull Call<MovieImages> call, @NonNull Response<MovieImages> response) {
                MovieImages movieImagesResponse = response.body();
                if (movieImagesResponse != null) {
                    ArrayList<MoviePostersAndBackdrops> imagesArrayList = new ArrayList<>();
                    List<MoviePostersAndBackdrops>      posterList      = movieImagesResponse.getPosters();
                    List<MoviePostersAndBackdrops>      backdropsList   = movieImagesResponse.getBackdrops();

                    imagesArrayList.addAll(posterList);
                    imagesArrayList.addAll(backdropsList);

                    if (imagesArrayList.size() > 0) {
                        MovieImagesAdapter imagesAdapter = new MovieImagesAdapter(MovieDetailsActivity.this, imagesArrayList);
                        binding.movieDetailImagesRecyclerView.setAdapter(imagesAdapter);
                        binding.movieDetailImagesLayout.setVisibility(View.VISIBLE);

                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailsActivity.this, R.anim.layout_slide_right);
                        binding.movieDetailImagesRecyclerView.setLayoutAnimation(controller);
                        binding.movieDetailImagesRecyclerView.scheduleLayoutAnimation();
                    }
                }
            }
            @Override
            public void onFailure(@NonNull Call<MovieImages> call, @NonNull Throwable t) {
            }
        });
    }

    private void prepareCastListDetails(MovieCredits movieCreditsResponse) {
        List<Cast> castList = movieCreditsResponse.getCast();
        if (castList != null && castList.size() > 0) {
            MovieCreditsCastAdapter castAdapter = new MovieCreditsCastAdapter(MovieDetailsActivity.this, castList);
            binding.movieDetailCastRecyclerView.setAdapter(castAdapter);
            binding.movieDetailCastLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailsActivity.this, R.anim.layout_slide_right);
            binding.movieDetailCastRecyclerView.setLayoutAnimation(controller);
            binding.movieDetailCastRecyclerView.scheduleLayoutAnimation();
        }
    }

    private void prepareCrewListDetails(MovieCredits movieCreditsResponse) {
        List<Crew> crewList = movieCreditsResponse.getCrew();
        if (crewList != null && crewList.size() > 0) {
            MovieCreditsCrewAdapter crewAdapter = new MovieCreditsCrewAdapter(MovieDetailsActivity.this, crewList);
            binding.movieDetailCrewRecyclerView.setAdapter(crewAdapter);
            binding.movieDetailCrewLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailsActivity.this, R.anim.layout_slide_right);
            binding.movieDetailCrewRecyclerView.setLayoutAnimation(controller);
            binding.movieDetailCrewRecyclerView.scheduleLayoutAnimation();
        }
    }

    private void prepareGenresListDetails(MovieDetails movieDetails) {
        List<Genres> genresList = movieDetails.getGenres();

        if (genresList != null && genresList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < genresList.size(); i++) {
                if (i == genresList.size() - 1)
                    stringBuilder.append(genresList.get(i).getName());
                else
                    stringBuilder.append(genresList.get(i).getName()).append(", ");
            }
            binding.movieDetailGenre.setText(stringBuilder.toString());
            binding.movieDetailGenreLayout.setVisibility(View.VISIBLE);
        }
    }

    private void prepareProductionCountriesListDetails(MovieDetails movieDetails) {
        List<ProductionCountries> productionCountriesList = movieDetails.getProduction_countries();
        if (productionCountriesList != null && productionCountriesList.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < productionCountriesList.size(); i++) {
                if (i == productionCountriesList.size() - 1)
                    stringBuilder.append(productionCountriesList.get(i).getName());
                else
                    stringBuilder.append(productionCountriesList.get(i).getName()).append(", ");
            }
            binding.movieDetailProductionCountry.setText(stringBuilder.toString());
            binding.movieDetailProductionCountryLayout.setVisibility(View.VISIBLE);
        }
    }

    private void prepareProductionCompaniesListDetails(MovieDetails movieDetailsResponse) {
        List<ProductionCompanies> productionCompaniesList = movieDetailsResponse.getProduction_companies();
        if (productionCompaniesList != null && productionCompaniesList.size() > 0) {
            MovieProductionCompaniesAdapter companiesAdapter = new MovieProductionCompaniesAdapter(MovieDetailsActivity.this, productionCompaniesList);
            binding.movieDetailProductionCompanyRecyclerView.setAdapter(companiesAdapter);
            binding.movieDetailProductionCompanyLayout.setVisibility(View.VISIBLE);

            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(MovieDetailsActivity.this, R.anim.layout_slide_right);
            binding.movieDetailProductionCompanyRecyclerView.setLayoutAnimation(controller);
            binding.movieDetailProductionCompanyRecyclerView.scheduleLayoutAnimation();
        }
    }

    private void prepareStringDetails(String stringDetails, AppCompatTextView textView, LinearLayoutCompat layout) {
        if (stringDetails != null && stringDetails.length() > 0) {
            textView.setText(stringDetails);
            layout.setVisibility(View.VISIBLE);
        }
    }



    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}