package com.wessam.movieapp.data.db.moviedetails;

import com.google.gson.annotations.SerializedName;

public class Genres {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;

    public Genres() {
    }

    public Genres(String name, int id) {
        this.name = name;
        this.id = id;
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
}
