package com.sujeong.composemovieapp.features.common.di

import com.sujeong.composemovieapp.features.common.data.network.api.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FeedProvideModule {
    @Provides
    @Singleton
    fun provideMoviesApi(
        retrofit: Retrofit
    ): MovieApi {
        return retrofit.create()
    }
}