package com.example.moviedbskillacademy.ui

import com.example.moviedbskillacademy.data.MovieDataSource
import com.example.moviedbskillacademy.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val view: MovieView, val dataSource: MovieDataSource) {

    fun discoverMovie() {
        view.showLoading()

        dataSource.discoverMovie()
            .enqueue(object : Callback<MovieResponse> {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    view.hideLoading()
                    if (response.isSuccessful) {
                        view.onResponse(response.body()?.results!!)
                    } else {
                        view.showMessage(response.message())
                    }
                }
                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                    view.hideLoading()
                    view.onFailure(t)
                }
            })
    }

}