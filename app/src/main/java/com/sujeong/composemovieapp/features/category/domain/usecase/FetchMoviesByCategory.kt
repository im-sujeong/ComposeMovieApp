package com.sujeong.composemovieapp.features.category.domain.usecase

import androidx.paging.PagingData
import com.sujeong.composemovieapp.features.common.domain.repository.MovieRepository
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchMoviesByCategory @Inject constructor(
    private val movieRepository: MovieRepository
) {
    operator fun invoke(movieCategory: MovieCategory): Flow<PagingData<Movie>> {
        return movieRepository.fetchMoviesByCategory(movieCategory)
    }
}