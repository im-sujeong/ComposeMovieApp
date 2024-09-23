package com.sujeong.composemovieapp.features.common.presentation.util

import kotlinx.serialization.Serializable

@Serializable
data object MovieFeedRoute

@Serializable
data class MovieDetailRoute(
    val movieId: Int
)