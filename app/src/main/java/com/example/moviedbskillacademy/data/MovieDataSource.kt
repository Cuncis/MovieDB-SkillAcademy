package com.example.moviedbskillacademy.data

import com.example.moviedbskillacademy.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataSource {

    @GET("/3/discover/movie")
    fun discoverMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<MovieResponse>

}