package com.wessam.movieapp.ui.actor;

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

import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.actordetails.ActorDetails;
import com.wessam.movieapp.data.db.actordetails.ActorImages;
import com.wessam.movieapp.data.db.actordetails.ActorImagesProfiles;
import com.wessam.movieapp.data.network.ApiService;
import com.wessam.movieapp.data.network.RetrofitClient;
import com.wessam.movieapp.databinding.ActivityActorDetailsBinding;
import com.wessam.movieapp.ui.actor.adapter.ActorImagesAdapter;
import com.wessam.movieapp.utils.Constants;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActorDetailsActivity extends AppCompatActivity {

    private ActivityActorDetailsBinding binding;
    private ApiService apiService;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_actor_details);

        Intent intent = getIntent();
        id = Integer.parseInt(Objects.requireNonNull(intent.getStringExtra(Constants.ACTOR_ID_KEY)));

        binding.actorDetailProfileImagesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        apiService = RetrofitClient.getClient().create(ApiService.class);

        getActorDetails();

    }

    private void getActorDetails() {
        Call<ActorDetails> actorDetailsCall = apiService.getActorDetails(id);

        actorDetailsCall.enqueue(new Callback<ActorDetails>() {
            @Override
            public void onResponse(@NonNull Call<ActorDetails> call, @NonNull Response<ActorDetails> response) {
                ActorDetails actorDetails = response.body();
                if (actorDetails != null) {
                    prepareActorDetails(actorDetails);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ActorDetails> call, @NonNull Throwable t) {

            }
        });
    }

    private void prepareActorDetails(ActorDetails actorDetails) {
        Picasso.get().load(actorDetails.getProfile_path()).placeholder(R.drawable.logo).into(binding.actorDetailsImageView);
        binding.actorDetailsName.setText(actorDetails.getName());
        prepareProfileImageList();
        prepareStringDetails(actorDetails.getBirthday(), binding.actorDetailBirthday, binding.actorDetailBirthdayLayout);
        prepareStringDetails(actorDetails.getPlace_of_birth(), binding.actorDetailPlaceOfBirth, binding.actorDetailPlaceOfBirthLayout);
        prepareStringDetails(actorDetails.getDeathday(), binding.actorDetailDeathDay, binding.actorDetailDeathDayLayout);
        prepareStringDetails(actorDetails.getBiography(), binding.actorDetailBiography, binding.actorDetailBiographyLayout);

    }

    private void prepareProfileImageList() {
        Call<ActorImages> imagesCall = apiService.getActorImages(id);
        imagesCall.enqueue(new Callback<ActorImages>() {
            @Override
            public void onResponse(@NonNull Call<ActorImages> call, @NonNull Response<ActorImages> response) {
                ActorImages images = response.body();
                if (images != null) {
                    List<ActorImagesProfiles> imagesProfilesList = images.getProfiles();
                    if (imagesProfilesList != null && imagesProfilesList.size() > 0) {
                        binding.actorDetailProfileImagesRecyclerView.setVisibility(View.VISIBLE);
                        ActorImagesAdapter imagesAdapter = new ActorImagesAdapter(ActorDetailsActivity.this, imagesProfilesList);
                        binding.actorDetailProfileImagesRecyclerView.setAdapter(imagesAdapter);

                        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(ActorDetailsActivity.this, R.anim.layout_slide_right);
                        binding.actorDetailProfileImagesRecyclerView.setLayoutAnimation(animationController);
                        binding.actorDetailProfileImagesRecyclerView.scheduleLayoutAnimation();
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<ActorImages> call, @NonNull Throwable t) {
            }
        });
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