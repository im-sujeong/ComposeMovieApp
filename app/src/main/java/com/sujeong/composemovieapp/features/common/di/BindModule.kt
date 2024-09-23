package com.sujeong.composemovieapp.features.common.di

import com.sujeong.composemovieapp.features.common.data.repository.MovieRepositoryImpl
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindModule {
    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository
}