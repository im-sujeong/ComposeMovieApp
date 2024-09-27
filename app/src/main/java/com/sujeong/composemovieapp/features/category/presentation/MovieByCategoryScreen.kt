package com.sujeong.composemovieapp.features.category.presentation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.paging.compose.collectAsLazyPagingItems
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.category.presentation.input.MovieByCategoryViewModelInput
import com.sujeong.composemovieapp.features.category.presentation.output.MovieByCategoryUiEffect
import com.sujeong.composemovieapp.ui.components.TopAppBarWithBack
import com.sujeong.composemovieapp.ui.components.movie.category.MovieGridItem
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import com.sujeong.composemovieapp.ui.theme.labelSmallProminent
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MovieByCategoryScreen(
    @StringRes category: Int,
    viewModel: MovieByCategoryViewModel = hiltViewModel(),
    onGoBack: () -> Unit,
    onNavigationToMovieDetail: (movieId: Int) -> Unit,
) {
    val state by viewModel.movieByCategoryState.collectAsStateWithLifecycle()
    val input = viewModel.input
    val movies = state.movies?.collectAsLazyPagingItems()

    val scrollState = rememberLazyGridState()
    val showTopButton by remember {
        derivedStateOf {
            scrollState.firstVisibleItemIndex > 0
        }
    }

    LaunchedEffect(key1 = true) {
        viewModel.movieByCategoryUiEffect.collectLatest { uiEffect ->
            when(uiEffect) {
                MovieByCategoryUiEffect.GoBack -> onGoBack()

                is MovieByCategoryUiEffect.OpenMovieDetail -> {
                    onNavigationToMovieDetail(uiEffect.movieId)
                }

                MovieByCategoryUiEffect.ScrollToTop -> {
                    scrollState.animateScrollToItem(0, 0)
                }
            }
        }
    }

    Scaffold(
        floatingActionButton = {
            if(showTopButton) {
                TopButton(
                    input = input
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            TopAppBarWithBack(
                title = stringResource(id = category),
                onBack = {
                    input.goBack()
                }
            )

            movies?.let {
                LazyVerticalGrid(
                    modifier = Modifier
                        .fillMaxSize(),
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(Paddings.padding16),
                    horizontalArrangement = Arrangement.spacedBy(Paddings.padding12),
                    contentPadding = PaddingValues(
                        horizontal = Paddings.padding24
                    ),
                    state = scrollState
                ) {
                    items(it.itemCount, key = { it }) { index ->
                        it[index]?.let {
                            MovieGridItem(
                                movie = it,
                                onClick = { movieId ->
                                    onNavigationToMovieDetail(movieId)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TopButton(
    modifier: Modifier = Modifier,
    input: MovieByCategoryViewModelInput? = null
) {
    FloatingActionButton(
        modifier = modifier.size(60.dp),
        onClick = {
            input?.scrollToTop()
        },
        shape = MaterialTheme.shapes.extraLarge,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Column {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_up),
                contentDescription = ""
            )

            Text(
                text = "TOP",
                style = MaterialTheme.typography.labelSmallProminent
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TopButtonPreview() {
    ComposeMovieAppTheme {
        TopButton()
    }
}

