package com.sujeong.composemovieapp.features.common.domain.repository

import com.sujeong.composemovieapp.features.common.domain.model.Movie

interface MovieRepository {
    suspend fun fetchMovies(genreId: Int): List<Movie>
}