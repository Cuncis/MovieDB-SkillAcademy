package com.example.moviedbskillacademy.ui

import com.example.moviedbskillacademy.data.MovieDataSource
import com.example.moviedbskillacademy.data.MovieResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(val view: MovieView, val dataSource: MovieDataSource) {

    private val disposable: CompositeDisposable = CompositeDisposable()

    fun discoverMovie() {
        view.showLoading()

        dataSource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())  //thread yg dibutuhkan akan berjalan pada UI Thread
            .subscribe({ response ->    // object yg kita expect(network) berhasil didapatkan
                view.hideLoading()
                view.onResponse(response.results)
            }, { error ->
                view.hideLoading()
                view.onFailure(error)
            }).addTo(disposable)        // digabungkan dalam 1 composite disposable
    }

    fun onDetach() {
        disposable.clear()      // ketika aplikasi di destroy maka kita akan panggil fungsi yg sama
    }                           // untuk mematikan thread yg sedang berjalan pada Rx(ReactiveProgramming)

}