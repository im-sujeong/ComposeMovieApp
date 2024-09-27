package com.sujeong.composemovieapp.features.feed.presentation.output

import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory

sealed class FeedUiEffect {
    data object ChangeTheme: FeedUiEffect()

    data class OpenMovieDetail(
        val movieId: Int
    ): FeedUiEffect()

    data object OpenAppInfoDialog: FeedUiEffect()

    data class OpenMoreMovies(
        val movieCategory: MovieCategory
    ): FeedUiEffect()
}