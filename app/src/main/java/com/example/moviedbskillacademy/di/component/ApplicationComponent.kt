package com.example.moviedbskillacademy.di.component

import com.example.moviedbskillacademy.BelajarApp
import com.example.moviedbskillacademy.di.builder.ActivityBuilder
import com.example.moviedbskillacademy.di.module.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class
])
interface ApplicationComponent : AndroidInjector<BelajarApp>