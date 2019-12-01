package com.wessam.movieapp.data.db.movieimages;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieImages {

    @SerializedName("posters")
    private List<MoviePostersAndBackdrops> posters;
    @SerializedName("backdrops")
    private List<MoviePostersAndBackdrops> backdrops;
    @SerializedName("id")
    private int id;

    public MovieImages() {
    }

    public MovieImages(List<MoviePostersAndBackdrops> posters, List<MoviePostersAndBackdrops> backdrops, int id) {
        this.posters = posters;
        this.backdrops = backdrops;
        this.id = id;
    }

    public List<MoviePostersAndBackdrops> getPosters() {
        return posters;
    }

    public void setPosters(List<MoviePostersAndBackdrops> posters) {
        this.posters = posters;
    }

    public List<MoviePostersAndBackdrops> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<MoviePostersAndBackdrops> backdrops) {
        this.backdrops = backdrops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
