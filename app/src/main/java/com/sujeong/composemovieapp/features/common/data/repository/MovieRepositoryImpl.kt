package com.sujeong.composemovieapp.features.common.data.repository

import com.sujeong.composemovieapp.features.common.data.mapper.toMovie
import com.sujeong.composemovieapp.features.common.data.network.api.MovieApi
import com.sujeong.composemovieapp.features.common.domain.model.Movie
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.library.di.qualifiers.IoDispatcher
import com.sujeong.composemovieapp.library.toAppError
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val movieApi: MovieApi
): MovieRepository {
    override suspend fun fetchMovies(
        genreId: Int
    ): List<Movie> = withContext(ioDispatcher){
        return@withContext try {
            movieApi.fetchMovies(genreId).results.map {
                it.toMovie()
            }
        }catch (e: Exception) {
            Timber.d("1111111")
            throw e.toAppError()
        }
    }
}