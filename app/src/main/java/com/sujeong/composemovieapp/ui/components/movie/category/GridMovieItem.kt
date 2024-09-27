package com.sujeong.composemovieapp.ui.components.movie.category

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.sujeong.composemovieapp.features.category.presentation.input.MovieByCategoryViewModelInput
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.ui.components.movie.Poster
import com.sujeong.composemovieapp.ui.components.movie.sample.MovieSampleProvider
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun MovieGridItem(
    modifier: Modifier = Modifier,
    movie: Movie,
    onClick: (movieId: Int) -> Unit = {}
) {
    Column(
        modifier = modifier
            .clickable {
                onClick(movie.id)
//                input?.openMovieDetail(movie.id)
            }
    ) {
        Poster(
            posterUrl = movie.poster,
            modifier = Modifier
                .aspectRatio(0.75f)
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
fun MovieGridPreview(
    @PreviewParameter(MovieSampleProvider::class) movie: Movie
) {
    ComposeMovieAppTheme {
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(9, key = { it }) { index ->
                MovieGridItem(movie = movie)
            }
        }
    }
}