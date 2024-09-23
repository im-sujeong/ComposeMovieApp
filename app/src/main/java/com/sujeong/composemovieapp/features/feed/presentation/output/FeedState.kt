package com.sujeong.composemovieapp.features.feed.presentation.output

import com.sujeong.composemovieapp.features.common.presentation.util.UiText
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie

data class FeedState(
    val isLoading: Boolean = true,
    val feedMovies: List<FeedMovie> = listOf(),
    val errorMessage: UiText? = null
)