package com.sujeong.composemovieapp.features.detail.presentation.output

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MovieDetailViewModelOutput {
    val movieDetailState: StateFlow<MovieDetailState>
    val movieDetailUiEffect: SharedFlow<MovieDetailUiEffect>
}