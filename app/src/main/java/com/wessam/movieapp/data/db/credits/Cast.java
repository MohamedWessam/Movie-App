package com.wessam.movieapp.data.db.credits;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

public class Cast {

    @SerializedName("profile_path")
    private String profile_path;
    @SerializedName("order")
    private int order;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("gender")
    private int gender;
    @SerializedName("credit_id")
    private String credit_id;
    @SerializedName("character")
    private String character;
    @SerializedName("cast_id")
    private int cast_id;

    public Cast() {
    }

    public Cast(String profile_path, int order, String name, int id, int gender, String credit_id, String character, int cast_id) {
        this.profile_path = profile_path;
        this.order = order;
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.credit_id = credit_id;
        this.character = character;
        this.cast_id = cast_id;
    }

    public String getProfile_path() {
        return Constants.IMAGES_BASE_URL + profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getCast_id() {
        return cast_id;
    }

    public void setCast_id(int cast_id) {
        this.cast_id = cast_id;
    }
}
