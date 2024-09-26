package com.sujeong.composemovieapp.features.feed.domain.usecase

import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovieType
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovieType.*
import javax.inject.Inject

class FetchMovies @Inject constructor(
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(): List<FeedMovie> {
        return FeedMovieType.entries.map { type ->
            when(type) {
                POPULAR -> {
                    FeedMovie(
                        feedMovieType = type,
                        movies = movieRepository.fetchPopularMovies()
                    )
                }

                NOW_PLAYING -> {
                    FeedMovie(
                        feedMovieType = type,
                        movies = movieRepository.fetchNowPlayingMovies()
                    )
                }

                UPCOMING -> {
                    FeedMovie(
                        feedMovieType = type,
                        movies = movieRepository.fetchUpcomingMovies()
                    )
                }

                TOP_RATED -> {
                    FeedMovie(
                        feedMovieType = type,
                        movies = movieRepository.fetchTopRatedMovies()
                    )
                }
            }
        }
    }
}