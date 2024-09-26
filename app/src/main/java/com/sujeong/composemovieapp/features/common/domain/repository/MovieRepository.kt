package com.sujeong.composemovieapp.features.common.domain.repository

import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import com.sujeong.composemovieapp.features.feed.domain.model.Movie

interface MovieRepository {
    suspend fun fetchPopularMovies(): List<Movie>

    suspend fun fetchNowPlayingMovies(): List<Movie>

    suspend fun fetchUpcomingMovies(): List<Movie>

    suspend fun fetchTopRatedMovies(): List<Movie>

    suspend fun fetchMovieDetail(movieId: Int): MovieDetail
}