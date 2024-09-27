package com.sujeong.composemovieapp.features.feed.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Alignment
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory
import com.sujeong.composemovieapp.features.feed.presentation.output.FeedUiEffect
import com.sujeong.composemovieapp.ui.components.TopAppBarForFeed
import com.sujeong.composemovieapp.ui.components.movie.feed.CategoryRow
import com.sujeong.composemovieapp.ui.theme.Paddings
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FeedScreen(
    onChangeTheme: () -> Unit,
    onNavigationToMovieDetail: (movieId: Int) -> Unit,
    onNavigationToAppInfoDialog: () -> Unit,
    onNavigationToMoreMovies: (movieCategory: MovieCategory) -> Unit,
    viewModel: FeedViewModel = hiltViewModel(),
) {
    val state by viewModel.feedState.collectAsStateWithLifecycle()
    val input = viewModel.input

    LaunchedEffect(key1 = true) {
        viewModel.feedUiEffect.collectLatest { uiEffect ->
            when(uiEffect) {
                is FeedUiEffect.OpenMovieDetail -> {
                    onNavigationToMovieDetail(uiEffect.movieId)
                }

                FeedUiEffect.OpenAppInfoDialog -> {
                    onNavigationToAppInfoDialog()
                }

                FeedUiEffect.ChangeTheme -> onChangeTheme()

                is FeedUiEffect.OpenMoreMovies -> {
                    onNavigationToMoreMovies(uiEffect.movieCategory)
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            TopAppBarForFeed(
                input = input
            )

            if(state.isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(vertical = Paddings.padding16),
                verticalArrangement = Arrangement.spacedBy(Paddings.padding36)
            ) {
                items(
                    state.feedMovies,
                    key = { feedMovie ->
                        feedMovie.movieCategory
                    }
                ) { feedMovie ->
                    CategoryRow(
                        feedMovie = feedMovie,
                        input = input
                    )
                }
            }
        }
    }
}