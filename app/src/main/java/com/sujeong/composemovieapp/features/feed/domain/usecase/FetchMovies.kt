package com.sujeong.composemovieapp.features.feed.domain.usecase

import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory.*
import javax.inject.Inject

class FetchMovies @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): List<FeedMovie> {
        return MovieCategory.entries.map { category ->
            when(category) {
                POPULAR -> {
                    FeedMovie(
                        movieCategory = category,
                        movies = movieRepository.fetchPopularMovies()
                    )
                }

                NOW_PLAYING -> {
                    FeedMovie(
                        movieCategory = category,
                        movies = movieRepository.fetchNowPlayingMovies()
                    )
                }

                UPCOMING -> {
                    FeedMovie(
                        movieCategory = category,
                        movies = movieRepository.fetchUpcomingMovies()
                    )
                }

                TOP_RATED -> {
                    FeedMovie(
                        movieCategory = category,
                        movies = movieRepository.fetchTopRatedMovies()
                    )
                }
            }
        }
    }
}