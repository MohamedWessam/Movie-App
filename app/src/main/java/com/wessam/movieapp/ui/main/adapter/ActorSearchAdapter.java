package com.wessam.movieapp.ui.main.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wessam.movieapp.R;
import com.wessam.movieapp.data.db.actor.ActorResults;
import com.wessam.movieapp.ui.actor.ActorDetailsActivity;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class ActorSearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {

    private Activity activity;
    private List<ActorResults> results;

    public ActorSearchAdapter(Activity activity, List<ActorResults> results) {
        this.activity = activity;
        this.results = results;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.search_layout_item, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        ActorResults actorResults = results.get(position);
        holder.setPosterImageView(actorResults.getProfile_path());

        final int id = actorResults.getId();

        String name = actorResults.getName();
        if (name != null){
            holder.posterTitle.setVisibility(View.VISIBLE);
            holder.posterTitle.setText(name);
        }else {
            holder.posterTitle.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(activity, ActorDetailsActivity.class);
            intent.putExtra(Constants.ACTOR_ID_KEY, String.valueOf(id));
            activity.startActivity(intent);

            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
