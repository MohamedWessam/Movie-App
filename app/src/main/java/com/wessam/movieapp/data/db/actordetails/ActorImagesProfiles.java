package com.wessam.movieapp.data.db.actordetails;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

public class ActorImagesProfiles {

    @SerializedName("aspect_ratio")
    private double aspect_ratio;
    @SerializedName("file_path")
    private String file_path;
    @SerializedName("vote_average")
    private int vote_average;
    @SerializedName("vote_count")
    private int vote_count;
    @SerializedName("height")
    private int height;
    @SerializedName("width")
    private int width;

    public ActorImagesProfiles() {
    }

    public ActorImagesProfiles(double aspect_ratio, String file_path, int vote_average, int vote_count, int height, int width) {
        this.aspect_ratio = aspect_ratio;
        this.file_path = file_path;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
        this.height = height;
        this.width = width;
    }

    public double getAspect_ratio() {
        return aspect_ratio;
    }

    public void setAspect_ratio(double aspect_ratio) {
        this.aspect_ratio = aspect_ratio;
    }

    public String getFile_path() {
        return Constants.IMAGES_BASE_URL + file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
