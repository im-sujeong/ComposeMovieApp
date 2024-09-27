package com.sujeong.composemovieapp.features.category.presentation.output

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface MovieByCategoryViewModelOutput {
    val movieByCategoryState: StateFlow<MovieByCategoryState>
    val movieByCategoryUiEffect: SharedFlow<MovieByCategoryUiEffect>
}