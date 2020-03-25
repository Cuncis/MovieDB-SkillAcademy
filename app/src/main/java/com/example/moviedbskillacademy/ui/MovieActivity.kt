package com.example.moviedbskillacademy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedbskillacademy.R
import com.example.moviedbskillacademy.data.Movie
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_movie.*
import javax.inject.Inject

class MovieActivity : DaggerAppCompatActivity(), MovieView {

    @Inject
    lateinit var presenter: MoviePresenter

    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        movieAdapter = MovieAdapter(this)
        rv_movie.layoutManager = LinearLayoutManager(this)
        rv_movie.setHasFixedSize(true)
        rv_movie.adapter = movieAdapter

        presenter.discoverMovie()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDetach()
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun onResponse(result: ArrayList<Movie>) {
        movieAdapter.setMovieList(result)
    }

    override fun onFailure(error: Throwable) {
        showMessage("" + error.message)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
