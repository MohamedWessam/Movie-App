package com.wessam.movieapp.ui.movie.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.credits.Cast;
import com.wessam.movieapp.ui.actor.ActorDetailsActivity;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class MovieCreditsCastAdapter extends RecyclerView.Adapter<MovieCreditsViewHolder> {

    private Activity activity;
    private List<Cast> castList;

    public MovieCreditsCastAdapter(Activity activity, List<Cast> castList) {
        this.activity = activity;
        this.castList = castList;
    }

    @NonNull
    @Override
    public MovieCreditsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.movie_credits_layout_item, parent, false);
        return new MovieCreditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieCreditsViewHolder holder, int position) {
        final Cast cast = castList.get(position);
        holder.setCreditsImage(cast.getProfile_path());
        holder.creditsName.setText(cast.getName());
        String character = activity.getResources().getString(R.string.character) + " " + cast.getCharacter();
        holder.creditsCharacter.setText(character);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ActorDetailsActivity.class);
            intent.putExtra(Constants.ACTOR_ID_KEY, String.valueOf(cast.getId()));
            activity.startActivity(intent);

            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    @Override
    public int getItemCount() {
        return castList.size();
    }
}