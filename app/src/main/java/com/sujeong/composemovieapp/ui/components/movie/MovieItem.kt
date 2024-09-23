package com.sujeong.composemovieapp.ui.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.common.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.presentation.input.FeedViewModelInput
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
        Poster(movie.poster)

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Paddings.padding8
            ),
            style = MaterialTheme.typography.titleSmall,
        )

        Row(
            modifier = Modifier.padding(
                top = Paddings.padding8
            )
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

@Composable
fun Poster(
    posterUrl: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(posterUrl)
                    .apply {
                        crossfade(true)
                    }.build()
            ),
            modifier = Modifier.fillMaxSize(),
            contentDescription = "영화 포스터",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview(
    @PreviewParameter(MovieSampleProvider::class) movie: Movie
) {
    ComposeMovieAppTheme{
        MovieItem(
            movie = movie,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}