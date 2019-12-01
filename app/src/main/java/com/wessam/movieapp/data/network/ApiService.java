package com.wessam.movieapp.data.network;

import com.wessam.movieapp.data.db.actor.Actor;
import com.wessam.movieapp.data.db.actordetails.ActorDetails;
import com.wessam.movieapp.data.db.actordetails.ActorImages;
import com.wessam.movieapp.data.db.credits.MovieCredits;
import com.wessam.movieapp.data.db.movie.Movie;
import com.wessam.movieapp.data.db.moviedetails.MovieDetails;
import com.wessam.movieapp.data.db.movieimages.MovieImages;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search/movie")
    Call<Movie> getMovieByQuery(@Query("query") String query);

    @GET("search/person")
    Call<Actor> getActorByQuery(@Query("query") String query);

    @GET("person/{person_id}")
    Call<ActorDetails> getActorDetails(@Path("person_id") int actorId);

    @GET("person/{person_id}/images")
    Call<ActorImages> getActorImages(@Path("person_id") int actorId);

    @GET("movie/{movie_id}")
    Call<MovieDetails> getMovieDetails(@Path("movie_id") int movieId);

    @GET("movie/{movie_id}/credits")
    Call<MovieCredits> getMovieCredits(@Path("movie_id") int movieId);

    @GET("movie/{movie_id}/images")
    Call<MovieImages> getMovieImages(@Path("movie_id") int movieId);

}
