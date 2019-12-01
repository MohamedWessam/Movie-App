package com.wessam.movieapp.data.db.actordetails;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

import java.util.List;

public class ActorDetails {

    @SerializedName("imdb_id")
    private String imdb_id;
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("profile_path")
    private String profile_path;
    @SerializedName("place_of_birth")
    private String place_of_birth;
    @SerializedName("popularity")
    private double popularity;
    @SerializedName("biography")
    private String biography;
    @SerializedName("gender")
    private int gender;
    @SerializedName("also_known_as")
    private List<String> also_known_as;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("known_for_department")
    private String known_for_department;
    @SerializedName("birthday")
    private String birthday;
    @SerializedName("deathday")
    private String deathday;

    public ActorDetails() {
    }

    public ActorDetails(String imdb_id, boolean adult, String profile_path, String place_of_birth, double popularity, String biography, int gender, List<String> also_known_as, String name, int id, String known_for_department, String birthday, String deathday) {
        this.imdb_id = imdb_id;
        this.adult = adult;
        this.profile_path = profile_path;
        this.place_of_birth = place_of_birth;
        this.popularity = popularity;
        this.biography = biography;
        this.gender = gender;
        this.also_known_as = also_known_as;
        this.name = name;
        this.id = id;
        this.known_for_department = known_for_department;
        this.birthday = birthday;
        this.deathday = deathday;
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
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

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public List<String> getAlso_known_as() {
        return also_known_as;
    }

    public void setAlso_known_as(List<String> also_known_as) {
        this.also_known_as = also_known_as;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnown_for_department() {
        return known_for_department;
    }

    public void setKnown_for_department(String known_for_department) {
        this.known_for_department = known_for_department;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isAdult() {
        return adult;
    }

    public String getDeathday() {
        return deathday;
    }

    public void setDeathday(String deathday) {
        this.deathday = deathday;
    }
}
