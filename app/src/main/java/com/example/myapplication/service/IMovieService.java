package com.example.myapplication.service;

import com.example.myapplication.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IMovieService {
    @GET("/3/movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apikey);

}
