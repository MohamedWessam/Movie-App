package com.wessam.movieapp.ui.main.adapter;

import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;

class SearchViewHolder extends RecyclerView.ViewHolder {

    KenBurnsView posterImageView;
    AppCompatTextView posterTitle;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);

        posterImageView = itemView.findViewById(R.id.poster_image_view);
        posterTitle = itemView.findViewById(R.id.poster_title);

        RandomTransitionGenerator generator = new RandomTransitionGenerator(2000, new DecelerateInterpolator());
        posterImageView.setTransitionGenerator(generator);
    }

    public void setPosterImageView(String url) {
        Picasso.get().load(url).placeholder(R.drawable.logo).into(posterImageView);
    }

}
