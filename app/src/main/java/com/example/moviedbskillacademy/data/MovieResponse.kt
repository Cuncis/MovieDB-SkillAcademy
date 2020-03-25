package com.example.moviedbskillacademy.data

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") var results: ArrayList<Movie>
)

data class Movie(
    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String
)
