package com.wessam.movieapp.data.db.actordetails;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActorImages {

    @SerializedName("id")
    private int id;
    @SerializedName("profiles")
    private List<ActorImagesProfiles> profiles;

    public ActorImages() {
    }

    public ActorImages(int id, List<ActorImagesProfiles> profiles) {
        this.id = id;
        this.profiles = profiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ActorImagesProfiles> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<ActorImagesProfiles> profiles) {
        this.profiles = profiles;
    }
}
