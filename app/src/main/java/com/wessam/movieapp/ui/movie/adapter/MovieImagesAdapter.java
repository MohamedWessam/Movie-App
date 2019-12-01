package com.wessam.movieapp.ui.movie.adapter;

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
import com.wessam.movieapp.data.db.movieimages.MoviePostersAndBackdrops;
import com.wessam.movieapp.ui.imageviewer.ImageViewerActivity;
import com.wessam.movieapp.utils.Constants;

import java.util.List;
import java.util.Objects;

public class MovieImagesAdapter extends RecyclerView.Adapter<MovieImagesAdapter.MovieImagesViewHolder> {

    private Activity activity;
    private List<MoviePostersAndBackdrops> postersList;

    public MovieImagesAdapter(Activity activity, List<MoviePostersAndBackdrops> postersList) {
        this.activity = activity;
        this.postersList = postersList;
    }

    @NonNull
    @Override
    public MovieImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.image_layout_item, parent, false);
        return new MovieImagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieImagesViewHolder holder, int position) {
        MoviePostersAndBackdrops posters = postersList.get(position);
        holder.getMovieImages(posters.getFile_path());

        holder.imageView.setOnClickListener(view -> {
            ActivityOptionsCompat compat = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                    holder.imageView, Objects.requireNonNull(ViewCompat.getTransitionName(holder.imageView)));
            Intent intent = new Intent(activity, ImageViewerActivity.class);
            intent.putExtra(Constants.IMAGE_URL_KEY, posters.getFile_path());
            activity.startActivity(intent, compat.toBundle());

        });
    }

    @Override
    public int getItemCount() {
        return postersList.size();
    }

    public class MovieImagesViewHolder extends RecyclerView.ViewHolder {

        private AppCompatImageView imageView;

        public MovieImagesViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recycler_image_view_item);
        }

        public void getMovieImages(String url) {
            Picasso.get().load(url).placeholder(R.drawable.logo).into(imageView);
        }

    }
}
