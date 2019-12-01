package com.wessam.movieapp.data.db.actor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Actor {

    @SerializedName("results")
    private List<ActorResults> results;
    @SerializedName("total_pages")
    private int total_pages;
    @SerializedName("total_results")
    private int total_results;
    @SerializedName("page")
    private int page;

    public Actor() {
    }

    public Actor(List<ActorResults> results, int total_pages, int total_results, int page) {
        this.results = results;
        this.total_pages = total_pages;
        this.total_results = total_results;
        this.page = page;
    }

    public List<ActorResults> getResults() {
        return results;
    }

    public void setResults(List<ActorResults> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
