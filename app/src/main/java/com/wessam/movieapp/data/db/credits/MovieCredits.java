package com.wessam.movieapp.data.db.credits;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieCredits {

    @SerializedName("crew")
    private List<Crew> crew;
    @SerializedName("cast")
    private List<Cast> cast;
    @SerializedName("id")
    private int id;

    public MovieCredits() {
    }

    public MovieCredits(List<Crew> crew, List<Cast> cast, int id) {
        this.crew = crew;
        this.cast = cast;
        this.id = id;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
