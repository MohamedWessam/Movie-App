package com.wessam.movieapp.data.db.moviedetails;

import com.google.gson.annotations.SerializedName;

public class SpokenLanguages {

    @SerializedName("name")
    private String name;
    @SerializedName("iso_639_1")
    private String iso_639_1;

    public SpokenLanguages() {
    }

    public SpokenLanguages(String name, String iso_639_1) {
        this.name = name;
        this.iso_639_1 = iso_639_1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso_639_1() {
        return iso_639_1;
    }

    public void setIso_639_1(String iso_639_1) {
        this.iso_639_1 = iso_639_1;
    }
}
