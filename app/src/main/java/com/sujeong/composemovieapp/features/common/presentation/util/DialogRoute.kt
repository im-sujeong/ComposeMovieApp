package com.sujeong.composemovieapp.features.common.presentation.util

import kotlinx.serialization.Serializable

@Serializable
data object AppInfoDialogRoute

@Serializable
data class MovieRatingDialogRoute(
    val movieId: Int
)