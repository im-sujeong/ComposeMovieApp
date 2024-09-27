package com.sujeong.composemovieapp.ui.components.movie.feed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
import com.sujeong.composemovieapp.ui.components.movie.Poster
import com.sujeong.composemovieapp.ui.components.movie.sample.MovieSampleProvider
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

private val MOVIE_ITEM_WIDTH = 120.dp

@Composable
fun MovieItem(
    movie: Movie,
    modifier: Modifier = Modifier,
    input: FeedViewModelInput? = null
) {
    Column(
        modifier = modifier
            .width(MOVIE_ITEM_WIDTH)
            .clickable {
                input?.openDetail(movie.id)
            }
    ) {
        Poster(
            posterUrl = movie.poster,
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        )

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Paddings.padding8
            ),
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.onBackground
        )

        Row(
            modifier = Modifier.padding(
                top = Paddings.padding8
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_star),
                contentDescription = "",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                text = movie.rating.toString(),
                modifier = Modifier.padding(
                    start = Paddings.padding4
                ),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview(
    @PreviewParameter(MovieSampleProvider::class) movie: Movie
) {
    ComposeMovieAppTheme(
        darkTheme = true
    ){
        MovieItem(
            movie = movie,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}