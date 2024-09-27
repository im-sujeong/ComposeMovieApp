package com.sujeong.composemovieapp.features.category.presentation.output

import androidx.paging.PagingData
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import kotlinx.coroutines.flow.Flow

data class MovieByCategoryState(
    val movies: Flow<PagingData<Movie>>? = null
)
