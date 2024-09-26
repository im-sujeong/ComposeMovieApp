package com.sujeong.composemovieapp.features.detail.presentation.output

import com.sujeong.composemovieapp.features.common.presentation.util.UiText
import com.sujeong.composemovieapp.features.detail.domain.model.Cast
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = true,
    val movieDetail: MovieDetail? = null,
    val casts: List<Cast> = emptyList(),
    val isMoreCast: Boolean = true,
    val errorMessage: UiText? = null
)