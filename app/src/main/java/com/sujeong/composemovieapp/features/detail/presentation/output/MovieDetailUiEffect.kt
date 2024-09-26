package com.sujeong.composemovieapp.features.detail.presentation.output

sealed class MovieDetailUiEffect {
    data object GoBack: MovieDetailUiEffect()

    data class OpenRatingDialog(
        val movieId: Int
    ): MovieDetailUiEffect()
}