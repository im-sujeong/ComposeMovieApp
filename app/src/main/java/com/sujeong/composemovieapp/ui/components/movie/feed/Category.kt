package com.sujeong.composemovieapp.ui.components.movie.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
import com.sujeong.composemovieapp.ui.components.movie.sample.FeedMovieSampleProvider
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun CategoryRow(
    feedMovie: FeedMovie,
    modifier: Modifier = Modifier,
    input: FeedViewModelInput? = null
) {
    Column(
        modifier = modifier
    ) {
        CategoryTitle(
            title = stringResource(
                feedMovie.feedMovieType.title
            )
        )

        Spacer(modifier = Modifier.height(Paddings.padding12))

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.padding20
            ),
            horizontalArrangement = Arrangement.spacedBy(Paddings.padding12)
        ) {
            items(
                feedMovie.movies,
                key = { movie ->
                    movie.id
                }
            ) {
                MovieItem(
                    movie = it,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(
    title: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(
                start = Paddings.padding24
            ),
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = stringResource(id = R.string.more),
            modifier = Modifier.padding(end = Paddings.padding24),
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryRowPreview(
    @PreviewParameter(FeedMovieSampleProvider::class) feedMovie: FeedMovie
) {
    ComposeMovieAppTheme {
        CategoryRow(feedMovie)
    }
}