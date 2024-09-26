package com.sujeong.composemovieapp.features.detail.domain.usecase

import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import javax.inject.Inject

class FetchMovieDetail @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(movieId: Int): MovieDetail {
        return movieRepository.fetchMovieDetail(movieId)
    }
}