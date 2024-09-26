package com.sujeong.composemovieapp.features.detail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.detail.presentation.input.MovieDetailViewModelInput
import com.sujeong.composemovieapp.features.detail.presentation.output.MovieDetailUiEffect
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieCast
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieGenre
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieInfo
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieOverview
import com.sujeong.composemovieapp.ui.components.movie.detail.MoviePoster
import com.sujeong.composemovieapp.ui.components.movie.detail.MoviePosterBackground
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieRating
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieRatingButton
import com.sujeong.composemovieapp.ui.components.movie.detail.MovieTitle
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import kotlinx.coroutines.flow.collectLatest

@Composable
fun MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    onGoBack: () -> Unit,
    onNavigationToMovieRatingDialog: (movieId: Int) -> Unit
) {
    val state by viewModel.movieDetailState.collectAsStateWithLifecycle()
    val input = viewModel.input

    LaunchedEffect(key1 = true) {
        viewModel.movieDetailUiEffect.collectLatest { uiEffect ->
            when(uiEffect) {
                MovieDetailUiEffect.GoBack -> onGoBack()
                is MovieDetailUiEffect.OpenRatingDialog -> onNavigationToMovieRatingDialog(
                    uiEffect.movieId
                )
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            if(state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.movieDetail?.let { movieDetail ->
                Box(
                    modifier = Modifier
                        .padding(bottom = innerPadding.calculateBottomPadding())
                        .verticalScroll(rememberScrollState())
                ) {
                    MoviePosterBackground(
                        posterUrl = movieDetail.poster
                    )

                    Column(
                        modifier = Modifier
                            .padding(
                                top = innerPadding.calculateTopPadding()
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MoviePoster(
                            modifier = Modifier.padding(top = Paddings.padding60),
                            posterUrl = movieDetail.poster
                        )

                        Spacer(modifier = Modifier.height(Paddings.padding40))

                        MovieTitle(
                            title = movieDetail.title,
                            tagline = movieDetail.tagline
                        )

                        Spacer(modifier = Modifier.height(Paddings.padding12))

                        MovieRating(rating = movieDetail.rating)

                        Spacer(modifier = Modifier.height(Paddings.padding40))

                        MovieGenre(
                            modifier = Modifier.padding(
                                horizontal = Paddings.padding24
                            ),
                            genres = movieDetail.genres
                        )

                        Spacer(modifier = Modifier.height(Paddings.padding16))

                        MovieInfo(
                            modifier = Modifier.padding(
                                horizontal = Paddings.padding24
                            ),
                            movieDetail = movieDetail
                        )

                        MovieOverview(
                            modifier = Modifier
                                .padding(top = Paddings.padding60)
                                .padding(horizontal = 24.dp),
                            overview = movieDetail.overview
                        )

                        Spacer(modifier = Modifier.height(Paddings.padding48))

                        MovieCast(
                            modifier = Modifier.padding(horizontal = Paddings.padding24),
                            casts = state.casts,
                            isMoreCast = state.isMoreCast,
                            input = input
                        )

                        Spacer(modifier = Modifier.height(138.dp))
                    }
                }
            }

            TopAppBar(
                modifier = Modifier.padding(innerPadding),
                input = input
            )

            MovieRatingButton(
                modifier = Modifier
                    .padding(innerPadding)
                    .align(Alignment.BottomCenter),
                input = input
            )
        }
    }
}

@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    input: MovieDetailViewModelInput? = null
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(Paddings.padding16))

        IconButton(
            modifier = Modifier
                .size(40.dp),
            onClick = {
                input?.goBack()
            }
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                contentDescription = "테마 변경",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailScreenPreview() {
    ComposeMovieAppTheme {
        TopAppBar()
    }
}