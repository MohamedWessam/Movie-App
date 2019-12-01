package com.wessam.movieapp.data.db.moviedetails;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class MovieDetails {

    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("video")
    private boolean video;
    @SerializedName("title")
    private String title;
    @SerializedName("tagline")
    private String tagline;
    @SerializedName("status")
    private String status;
    @SerializedName("spoken_languages")
    private List<SpokenLanguages> spoken_languages;
    @SerializedName("runtime")
    private int runtime;
    @SerializedName("revenue")
    private int revenue;
    @SerializedName("release_date")
    private String release_date;
    @SerializedName("production_countries")
    private List<ProductionCountries> production_countries;
    @SerializedName("production_companies")
    private List<ProductionCompanies> production_companies;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("overview")
    private String overview;
    @SerializedName("original_title")
    private String original_title;
    @SerializedName("original_language")
    private String original_language;
    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("id")
    private int id;
    @SerializedName("homepage")
    private String homepage;
    @SerializedName("genres")
    private List<Genres> genres;
    @SerializedName("budget")
    private int budget;
    @SerializedName("backdrop_path")
    private String backdrop_path;
    @SerializedName("adult")
    private boolean adult;

    public MovieDetails() {
    }

    public MovieDetails(int vote_count, double vote_average, boolean video, String title, String tagline, String status, List<SpokenLanguages> spoken_languages, int runtime, int revenue, String release_date, List<ProductionCountries> production_countries, List<ProductionCompanies> production_companies, String poster_path, double popularity, String overview, String original_title, String original_language, String imdb_id, int id, String homepage, List<Genres> genres, int budget, String backdrop_path, boolean adult) {
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.video = video;
        this.title = title;
        this.tagline = tagline;
        this.status = status;
        this.spoken_languages = spoken_languages;
        this.runtime = runtime;
        this.revenue = revenue;
        this.release_date = release_date;
        this.production_countries = production_countries;
        this.production_companies = production_companies;
        this.poster_path = poster_path;
        this.popularity = popularity;
        this.overview = overview;
        this.original_title = original_title;
        this.original_language = original_language;
        this.imdb_id = imdb_id;
        this.id = id;
        this.homepage = homepage;
        this.genres = genres;
        this.budget = budget;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public boolean getVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<SpokenLanguages> getSpoken_languages() {
        return spoken_languages;
    }

    public void setSpoken_languages(List<SpokenLanguages> spoken_languages) {
        this.spoken_languages = spoken_languages;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<ProductionCountries> getProduction_countries() {
        return production_countries;
    }

    public void setProduction_countries(List<ProductionCountries> production_countries) {
        this.production_countries = production_countries;
    }

    public List<ProductionCompanies> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompanies> production_companies) {
        this.production_companies = production_companies;
    }

    public String getPoster_path() {
        return Constants.IMAGES_BASE_URL + poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
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

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public List<Genres> getGenres() {
        return genres;
    }

    public void setGenres(List<Genres> genres) {
        this.genres = genres;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getBackdrop_path() {
        return Constants.IMAGES_BASE_URL + backdrop_path;
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
}
