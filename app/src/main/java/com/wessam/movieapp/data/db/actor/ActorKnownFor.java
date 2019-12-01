package com.wessam.movieapp.data.db.actor;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class ActorKnownFor {

    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("overview")
    private String overview;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("title")
    private String title;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("media_type")
    private String media_type;
    @SerializedName("video")
    private boolean video;
    @SerializedName("id")
    private int id;
    @SerializedName("vote_count")
    private int vote_count;

    public ActorKnownFor() {
    }

    public ActorKnownFor(String poster_path, String overview, boolean adult, String backdrop_path, List<Integer> genre_ids, String original_title, String original_language, String release_date, String title, double vote_average, String media_type, boolean video, int id, int vote_count) {
        this.poster_path = poster_path;
        this.overview = overview;
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.genre_ids = genre_ids;
        this.original_title = original_title;
        this.original_language = original_language;
        this.release_date = release_date;
        this.title = title;
        this.vote_average = vote_average;
        this.media_type = media_type;
        this.video = video;
        this.id = id;
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        return Constants.IMAGES_BASE_URL + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public List<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }
}
