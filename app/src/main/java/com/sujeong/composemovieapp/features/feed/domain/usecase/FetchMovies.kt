package com.sujeong.composemovieapp.features.feed.domain.usecase

import com.sujeong.composemovieapp.features.common.domain.model.MovieGenre
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie
import javax.inject.Inject

class FetchMovies @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): List<FeedMovie> {
        return MovieGenre.entries.map {
            FeedMovie(
                genre = it,
                movies = movieRepository.fetchMovies(it.genreId)
            )
        }
    }
}