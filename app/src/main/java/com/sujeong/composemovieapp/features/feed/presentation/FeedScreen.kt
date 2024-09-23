package com.sujeong.composemovieapp.features.feed.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
import com.sujeong.composemovieapp.features.feed.presentation.output.FeedUiEffect
import com.sujeong.composemovieapp.ui.components.movie.CategoryRow
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import kotlinx.coroutines.flow.collectLatest

@Composable
fun FeedScreen(
    onNavigationToMovieDetail: (movieId: Int) -> Unit,
    onNavigationToAppInfoDialog: () -> Unit,
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
            }
        }
    }

    Column {
        TopAppBar(input)

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
                    feedMovie.genre.genreId
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

@Composable
fun TopAppBar(
    input: FeedViewModelInput? = null
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_logo),
            contentDescription = "앱 로고",
            modifier = Modifier
                .padding(start = Paddings.padding24)
                .align(Alignment.CenterStart)
        )

        Row(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = Paddings.padding16)
        ) {
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {

                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_change_theme),
                    contentDescription = "테마 변경",
                )
            }
            
            IconButton(
                modifier = Modifier.size(40.dp),
                onClick = {
                    input?.openAppInfo()
                }
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_app_info),
                    contentDescription = "앱 정보",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBarPreview() {
    ComposeMovieAppTheme {
        TopAppBar()
    }
}