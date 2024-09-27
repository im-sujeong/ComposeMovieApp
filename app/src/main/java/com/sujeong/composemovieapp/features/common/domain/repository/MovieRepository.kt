package com.sujeong.composemovieapp.features.common.domain.repository

import androidx.paging.PagingData
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    suspend fun fetchPopularMovies(): List<Movie>


    suspend fun fetchNowPlayingMovies(): List<Movie>

    suspend fun fetchUpcomingMovies(): List<Movie>

    suspend fun fetchTopRatedMovies(): List<Movie>

    fun fetchMoviesByCategory(movieCategory: MovieCategory): Flow<PagingData<Movie>>

    suspend fun fetchMovieDetail(movieId: Int): MovieDetail
}