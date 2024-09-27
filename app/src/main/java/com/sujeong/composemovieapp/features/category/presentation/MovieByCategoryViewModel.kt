package com.sujeong.composemovieapp.features.category.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import androidx.paging.cachedIn
import com.sujeong.composemovieapp.features.category.domain.usecase.FetchMoviesByCategory
import com.sujeong.composemovieapp.features.category.presentation.input.MovieByCategoryViewModelInput
import com.sujeong.composemovieapp.features.category.presentation.output.MovieByCategoryState
import com.sujeong.composemovieapp.features.category.presentation.output.MovieByCategoryUiEffect
import com.sujeong.composemovieapp.features.category.presentation.output.MovieByCategoryViewModelOutput
import com.sujeong.composemovieapp.features.common.presentation.util.MovieByCategoryRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieByCategoryViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchMoviesByCategory: FetchMoviesByCategory
): ViewModel(), MovieByCategoryViewModelInput, MovieByCategoryViewModelOutput {
    private val category = savedStateHandle.toRoute<MovieByCategoryRoute>().category

    val input: MovieByCategoryViewModelInput = this

    private var isInitialized = false

    private val _movieByCategoryState = MutableStateFlow(MovieByCategoryState())
    override val movieByCategoryState: StateFlow<MovieByCategoryState>
        get() = _movieByCategoryState.onStart {
            if(!isInitialized) {
                fetchData()

                isInitialized = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = MovieByCategoryState()
        )

    private val _movieByCategoryUiEffect = MutableSharedFlow<MovieByCategoryUiEffect>()
    override val movieByCategoryUiEffect: SharedFlow<MovieByCategoryUiEffect>
        get() = _movieByCategoryUiEffect

    private suspend fun fetchData() {
        _movieByCategoryState.value = _movieByCategoryState.value.copy(
            movies = fetchMoviesByCategory(category).cachedIn(viewModelScope)
        )
    }

    override fun openMovieDetail(movieId: Int) {
        viewModelScope.launch {
            _movieByCategoryUiEffect.emit(
                MovieByCategoryUiEffect.OpenMovieDetail(movieId)
            )
        }
    }

    override fun goBack() {
        viewModelScope.launch {
            _movieByCategoryUiEffect.emit(
                MovieByCategoryUiEffect.GoBack
            )
        }
    }

    override fun scrollToTop() {
        viewModelScope.launch {
            _movieByCategoryUiEffect.emit(
                MovieByCategoryUiEffect.ScrollToTop
            )
        }
    }
}