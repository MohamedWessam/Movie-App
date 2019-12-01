package com.wessam.movieapp.data.db.actor;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class ActorResults {

    @SerializedName("gender")
    private int gender;
    @SerializedName("known_for")
    private List<ActorKnownFor> known_for;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("profile_path")
    private String profile_path;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("known_for_department")
    private String known_for_department;
    @SerializedName("popularity")
    private double popularity;

    public ActorResults() {
    }

    public ActorResults(int gender, List<ActorKnownFor> known_for, boolean adult, String profile_path, int id, String name, String known_for_department, double popularity) {
        this.gender = gender;
        this.known_for = known_for;
        this.adult = adult;
        this.profile_path = profile_path;
        this.id = id;
        this.name = name;
        this.known_for_department = known_for_department;
        this.popularity = popularity;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<ActorKnownFor> getKnown_for() {
        return known_for;
    }

    public void setKnown_for(List<ActorKnownFor> known_for) {
        this.known_for = known_for;
    }

    public boolean getAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getProfile_path() {
        return Constants.IMAGES_BASE_URL + profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
}
