package com.example.moviedbskillacademy.di.builder

import com.example.moviedbskillacademy.di.module.MovieModule
import com.example.moviedbskillacademy.di.scope.Presentation
import com.example.moviedbskillacademy.ui.MovieActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun contributeMovieActivity(): MovieActivity

}