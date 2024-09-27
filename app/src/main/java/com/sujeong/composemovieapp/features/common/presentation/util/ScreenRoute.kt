package com.sujeong.composemovieapp.features.common.presentation.util

import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import kotlinx.serialization.Serializable

@Serializable
data object MovieFeedRoute

@Serializable
data class MovieByCategoryRoute(
    val category: MovieCategory
)

@Serializable
data class MovieDetailRoute(
    val movieId: Int
)