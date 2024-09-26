package com.sujeong.composemovieapp.features.feed.presentation.output

sealed class FeedUiEffect {
    data object ChangeTheme: FeedUiEffect()

    data class OpenMovieDetail(
        val movieId: Int
    ): FeedUiEffect()

    data object OpenAppInfoDialog: FeedUiEffect()
}