package com.wessam.movieapp.data.db.movie;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class MovieResults {

    @SerializedName("release_date")
    private String release_date;
    @SerializedName("overview")
    private String overview;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("title")
    private String title;
    @SerializedName("genre_ids")
    private List<Integer> genre_ids;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("id")
    private int id;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("video")
    private boolean video;
    @SerializedName("vote_count")
    private long vote_count;
    @SerializedName("popularity")
    private double popularity;

    public MovieResults() {
    }

    public MovieResults(String release_date, String overview, double vote_average, String title, List<Integer> genre_ids, String original_title, String original_language, String backdrop_path, boolean adult, int id, String poster_path, boolean video, long vote_count, double popularity) {
        this.release_date = release_date;
        this.overview = overview;
        this.vote_average = vote_average;
        this.title = title;
        this.genre_ids = genre_ids;
        this.original_title = original_title;
        this.original_language = original_language;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.id = id;
        this.poster_path = poster_path;
        this.video = video;
        this.vote_count = vote_count;
        this.popularity = popularity;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return Constants.IMAGES_BASE_URL + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public long getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
