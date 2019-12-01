package com.wessam.movieapp.data.db.movieimages;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

public class MoviePostersAndBackdrops {

    @SerializedName("width")
    private int width;
    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("vote_average")
    private double vote_average;
    @SerializedName("iso_639_1")
    private String iso_639_1;
    @SerializedName("height")
    private int height;
    @SerializedName("file_path")
    private String file_path;
    @SerializedName("aspect_ratio")
    private double aspect_ratio;

    public MoviePostersAndBackdrops() {
    }

    public MoviePostersAndBackdrops(int width, int vote_count, double vote_average, String iso_639_1, int height, String file_path, double aspect_ratio) {
        this.width = width;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.iso_639_1 = iso_639_1;
        this.height = height;
        this.file_path = file_path;
        this.aspect_ratio = aspect_ratio;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
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

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFile_path() {
        return Constants.IMAGES_BASE_URL + file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public double getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }
}
