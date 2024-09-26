package com.sujeong.composemovieapp.features.dialogs.rating

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieRatingDialogRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieRatingViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    val movieId = savedStateHandle.toRoute<MovieRatingDialogRoute>().movieId
}