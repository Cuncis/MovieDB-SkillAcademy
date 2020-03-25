package com.example.moviedbskillacademy.di.module

import com.example.moviedbskillacademy.data.MovieDataSource
import com.example.moviedbskillacademy.ui.MovieActivity
import com.example.moviedbskillacademy.ui.MoviePresenter
import com.example.moviedbskillacademy.ui.MovieView
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
abstract class MovieModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesMovieDataSource(retrofit: Retrofit): MovieDataSource =
            retrofit.create(MovieDataSource::class.java)

        @JvmStatic
        @Provides
        fun providesMoviePresenter(
            view: MovieView,
            dataSource: MovieDataSource
        ): MoviePresenter = MoviePresenter(view, dataSource)

    }

    @Binds
    abstract fun bindMovieView(activity: MovieActivity): MovieView

}