package com.sujeong.composemovieapp.features.common.data.repository

import com.sujeong.composemovieapp.features.common.data.mapper.toMovie
import com.sujeong.composemovieapp.features.common.data.mapper.toMovieDetail
import com.sujeong.composemovieapp.features.common.data.network.api.MovieApi
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import com.sujeong.composemovieapp.library.di.qualifiers.IoDispatcher
import com.sujeong.composemovieapp.library.toAppError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val movieApi: MovieApi
): MovieRepository {
    override suspend fun fetchPopularMovies(): List<Movie> = withContext(ioDispatcher){
        return@withContext try {
            movieApi.fetchPopularMovies().results.map {
                it.toMovie()
            }
        }catch (e: Exception) {
            throw e.toAppError()
        }
    }

    override suspend fun fetchNowPlayingMovies(): List<Movie> = withContext(ioDispatcher) {
        return@withContext try {
            movieApi.fetchNowPlayingMovies().results.map {
                it.toMovie()
            }
        }catch (e: Exception) {
            throw e.toAppError()
        }
    }

    override suspend fun fetchUpcomingMovies(): List<Movie> = withContext(ioDispatcher) {
        return@withContext try {
            movieApi.fetchUpcomingMovies().results.map {
                it.toMovie()
            }
        }catch (e: Exception) {
            throw e.toAppError()
        }
    }

    override suspend fun fetchTopRatedMovies(): List<Movie> = withContext(ioDispatcher) {
        return@withContext try {
            movieApi.fetchTopRatedMovies().results.map {
                it.toMovie()
            }
        }catch (e: Exception) {
            throw e.toAppError()
        }
    }

    override suspend fun fetchMovieDetail(
        movieId: Int
    ): MovieDetail = withContext(ioDispatcher){
        return@withContext try {
            movieApi
                .fetchMovieDetail(movieId)
                .toMovieDetail(
                    movieApi.fetchMovieCredits(movieId),
                    movieApi.fetchMovieReleaseInfo(movieId).results
                )
        }catch (e: Exception) {
            throw e.toAppError()
        }
    }
}