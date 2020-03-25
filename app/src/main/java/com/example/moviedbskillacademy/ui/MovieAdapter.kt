package com.example.moviedbskillacademy.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbskillacademy.R
import com.example.moviedbskillacademy.data.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(private val context: Context): RecyclerView.Adapter<MovieAdapter.MovieHolder>() {

    private var movieList: List<Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        return MovieHolder(LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false))
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movieList[position])
    }

    fun setMovieList(movieList: ArrayList<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    inner class MovieHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title: TextView = view.tv_title
        private val overview: TextView = view.tv_overview

        fun bind(movie: Movie) {
            title.text = movie.title
            overview.text = movie.overview
        }
    }
}