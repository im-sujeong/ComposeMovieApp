package com.sujeong.composemovieapp.features.category.presentation.output

sealed class MovieByCategoryUiEffect {
    data class OpenMovieDetail(
        val movieId: Int
    ): MovieByCategoryUiEffect()

    data object GoBack: MovieByCategoryUiEffect()

    data object ScrollToTop: MovieByCategoryUiEffect()
}