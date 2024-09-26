package com.sujeong.composemovieapp.features.feed.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sujeong.composemovieapp.features.feed.domain.usecase.FetchMovies
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
import com.sujeong.composemovieapp.features.feed.presentation.output.FeedUiEffect
import com.sujeong.composemovieapp.features.feed.presentation.output.FeedState
import com.sujeong.composemovieapp.features.feed.presentation.output.FeedViewModelOutput
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
class FeedViewModel @Inject constructor(
    private val fetchMovies: FetchMovies
): ViewModel(), FeedViewModelInput, FeedViewModelOutput {
    val input: FeedViewModelInput = this

    private var isInitialized = false

    private val _feedState = MutableStateFlow(FeedState())
    override val feedState: StateFlow<FeedState>
        get() = _feedState.onStart {
            if(!isInitialized) {
                fetchData()

                isInitialized = true
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FeedState()
        )

    private val _feedUiEffect = MutableSharedFlow<FeedUiEffect>()
    override val feedUiEffect: SharedFlow<FeedUiEffect>
        get() = _feedUiEffect

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

    private fun fetchData() = viewModelScope.launch(errorHandler){
        _feedState.value = feedState.value.copy(
            isLoading = false,
            feedMovies = fetchMovies()
        )
    }

    override fun changeTheme() {
        viewModelScope.launch {
            _feedUiEffect.emit(
                FeedUiEffect.ChangeTheme
            )
        }
    }

    override fun openDetail(movieId: Int) {
        viewModelScope.launch {
            _feedUiEffect.emit(
                FeedUiEffect.OpenMovieDetail(
                    movieId
                )
            )
        }
    }

    override fun openAppInfo() {
        viewModelScope.launch {
            _feedUiEffect.emit(
                FeedUiEffect.OpenAppInfoDialog
            )
        }
    }

    override fun refreshFeed() { }
}