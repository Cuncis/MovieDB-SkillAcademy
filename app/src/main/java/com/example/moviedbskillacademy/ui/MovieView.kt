package com.example.moviedbskillacademy.ui

import com.example.moviedbskillacademy.data.Movie


interface MovieView {
    fun showLoading()
    fun hideLoading()
    fun onResponse(result: ArrayList<Movie>)
    fun onFailure(error: Throwable)
    fun showMessage(message: String)
}