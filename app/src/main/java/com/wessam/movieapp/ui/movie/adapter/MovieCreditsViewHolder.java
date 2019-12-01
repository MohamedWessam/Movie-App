package com.wessam.movieapp.ui.movie.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;
import com.wessam.movieapp.R;

public class MovieCreditsViewHolder extends RecyclerView.ViewHolder {

     KenBurnsView creditsImage;
     AppCompatTextView creditsName, creditsCharacter;

    public MovieCreditsViewHolder(@NonNull View itemView) {
        super(itemView);

        creditsImage = itemView.findViewById(R.id.movie_credits_image_view);
        creditsName = itemView.findViewById(R.id.movie_credits_name);
        creditsCharacter = itemView.findViewById(R.id.movie_credits_character);
    }

    void setCreditsImage(String url){
        Picasso.get().load(url).placeholder(R.drawable.logo).into(creditsImage);
    }

}
