package com.wessam.movieapp.ui.actor.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.actordetails.ActorImagesProfiles;
import com.wessam.movieapp.ui.imageviewer.ImageViewerActivity;
import com.wessam.movieapp.utils.Constants;

import java.util.List;
import java.util.Objects;

public class ActorImagesAdapter extends RecyclerView.Adapter<ActorImagesAdapter.ActorImagesViewHolder> {

    private Activity activity;
    private List<ActorImagesProfiles> actorImagesProfilesList;

    public ActorImagesAdapter(Activity activity, List<ActorImagesProfiles> actorImagesProfilesList) {
        this.activity = activity;
        this.actorImagesProfilesList = actorImagesProfilesList;
    }

    @NonNull
    @Override
    public ActorImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_layout_item, parent, false);
        return new ActorImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ActorImagesViewHolder holder, int position) {
        ActorImagesProfiles imagesProfiles = actorImagesProfilesList.get(position);
        holder.getActorImages(imagesProfiles.getFile_path());

        holder.imageView.setOnClickListener(view -> {
            ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    holder.imageView, Objects.requireNonNull(ViewCompat.getTransitionName(holder.imageView)));
            Intent intent = new Intent(activity, ImageViewerActivity.class);
            intent.putExtra(Constants.IMAGE_URL_KEY, imagesProfiles.getFile_path());
            activity.startActivity(intent, compat.toBundle());

        });
    }

    @Override
    public int getItemCount() {
        return actorImagesProfilesList.size();
    }

    public class ActorImagesViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView imageView;

        public ActorImagesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_image_view_item);
        }

        public void getActorImages(String url) {
            Picasso.get().load(url).placeholder(R.drawable.logo).into(imageView);
        }

    }
}
