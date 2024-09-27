package com.sujeong.composemovieapp.features.common.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sujeong.composemovieapp.features.common.data.mapper.toMovie
import com.sujeong.composemovieapp.features.common.data.mapper.toMovieDetail
import com.sujeong.composemovieapp.features.common.data.network.api.MovieApi
import com.sujeong.composemovieapp.features.common.data.network.paging.MovieByCategoryPagingSource
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import com.sujeong.composemovieapp.library.di.qualifiers.IoDispatcher
import com.sujeong.composemovieapp.library.toAppError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
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

    override fun fetchMoviesByCategory(
        movieCategory: MovieCategory
    ): Flow<PagingData<Movie>> = Pager(
        config = PagingConfig(
            pageSize = 20,
            enablePlaceholders = false
        ),
        pagingSourceFactory = {
            MovieByCategoryPagingSource(
                movieApi = movieApi,
                movieCategory = movieCategory
            )
        }
    ).flow

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