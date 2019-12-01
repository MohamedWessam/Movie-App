package com.wessam.movieapp.data.db.moviedetails;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

public class ProductionCompanies {

    @SerializedName("origin_country")
    private String origin_country;
    @SerializedName("name")
    private String name;
    @SerializedName("logo_path")
    private String logo_path;
    @SerializedName("id")
    private int id;

    public ProductionCompanies() {
    }

    public ProductionCompanies(String origin_country, String name, String logo_path, int id) {
        this.origin_country = origin_country;
        this.name = name;
        this.logo_path = logo_path;
        this.id = id;
    }

    public String getOrigin_country() {
        return origin_country;
    }

    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo_path() {
        return Constants.IMAGES_BASE_URL + logo_path;
    }

    public void setLogo_path(String logo_path) {
        this.logo_path = logo_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
