package com.sujeong.composemovieapp.features.detail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.sujeong.composemovieapp.features.common.presentation.util.MovieDetailRoute
import com.sujeong.composemovieapp.features.detail.domain.usecase.FetchMovieDetail
import com.sujeong.composemovieapp.features.detail.presentation.input.MovieDetailViewModelInput
import com.sujeong.composemovieapp.features.detail.presentation.output.MovieDetailState
import com.sujeong.composemovieapp.features.detail.presentation.output.MovieDetailUiEffect
import com.sujeong.composemovieapp.features.detail.presentation.output.MovieDetailViewModelOutput
import com.sujeong.composemovieapp.library.model.AppError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val fetchMovieDetail: FetchMovieDetail
): ViewModel(), MovieDetailViewModelInput, MovieDetailViewModelOutput {
    private val movieId = savedStateHandle.toRoute<MovieDetailRoute>().movieId

    val input: MovieDetailViewModelInput = this

    private var isInitialized = false

    private val _movieDetailState = MutableStateFlow(MovieDetailState())
    override val movieDetailState: StateFlow<MovieDetailState>
        get() = _movieDetailState.onStart {
            if(!isInitialized) {
                fetchData()

                isInitialized = true
            }
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            MovieDetailState()
        )

    private val _movieDetailUiEffect = MutableSharedFlow<MovieDetailUiEffect>()
    override val movieDetailUiEffect: SharedFlow<MovieDetailUiEffect>
        get() = _movieDetailUiEffect

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        if(throwable is AppError) {
            when(throwable) {
                AppError.InvalidApiKey -> Timber.d("Invalid Api Key")
                AppError.ServerError -> Timber.d("ServerError")
                AppError.Unknown -> Timber.d("Unknown")
            }
        }else {

        }
    }

    private fun fetchData() = viewModelScope.launch(errorHandler) {
        val movieDetail = fetchMovieDetail(movieId)

        _movieDetailState.value = movieDetailState.value.copy(
            isLoading = false,
            movieDetail = movieDetail,
            casts = movieDetail.casts.take(5)
        )
    }

    override fun goBack() {
        viewModelScope.launch {
            _movieDetailUiEffect.emit(
                MovieDetailUiEffect.GoBack
            )
        }
    }

    override fun openRatingDialog() {
        viewModelScope.launch {
            _movieDetailUiEffect.emit(
                MovieDetailUiEffect.OpenRatingDialog(
                    movieId
                )
            )
        }
    }

    override fun moreCast() {
        viewModelScope.launch {
            val originalCasts = _movieDetailState.value.movieDetail
            val currentCastSize = _movieDetailState.value.casts.size
            val casts = originalCasts?.casts?.take(currentCastSize + 5) ?: listOf()

            _movieDetailState.value = _movieDetailState.value
                .copy(
                    casts = casts,
                    isMoreCast = (originalCasts?.casts?.size ?: 0) > casts.size
                )
        }
    }
}