package com.wessam.movieapp.data.db.credits;

import com.google.gson.annotations.SerializedName;
import com.wessam.movieapp.utils.Constants;

public class Crew {

    @SerializedName("profile_path")
    private String profile_path;
    @SerializedName("name")
    private String name;
    @SerializedName("job")
    private String job;
    @SerializedName("id")
    private int id;
    @SerializedName("gender")
    private int gender;
    @SerializedName("department")
    private String department;
    @SerializedName("credit_id")
    private String credit_id;

    public Crew() {
    }

    public Crew(String profile_path, String name, String job, int id, int gender, String department, String credit_id) {
        this.profile_path = profile_path;
        this.name = name;
        this.job = job;
        this.id = id;
        this.gender = gender;
        this.department = department;
        this.credit_id = credit_id;
    }

    public String getProfile_path() {
        return Constants.IMAGES_BASE_URL + profile_path;
    }

    public void setProfile_path(String profile_path) {
        this.profile_path = profile_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCredit_id() {
        return credit_id;
    }

    public void setCredit_id(String credit_id) {
        this.credit_id = credit_id;
    }
}
