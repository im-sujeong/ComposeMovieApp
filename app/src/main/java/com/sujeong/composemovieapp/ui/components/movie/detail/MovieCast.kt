package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.detail.domain.model.Cast
import com.sujeong.composemovieapp.features.detail.presentation.input.MovieDetailViewModelInput
import com.sujeong.composemovieapp.ui.components.movie.sample.CastsSampleProvider
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun MovieCast(
    modifier: Modifier = Modifier,
    casts: List<Cast>,
    isMoreCast: Boolean = true,
    input: MovieDetailViewModelInput? = null
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(Paddings.padding12),
    ) {
        Text(
            text = stringResource(id = R.string.movie_cast),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onBackground
        )

        casts.forEach { cast ->
            key(cast.id) {
                MovieCastItem(cast = cast)
            }
        }

        if(isMoreCast) {
            Row(
                modifier = Modifier
                    .height(40.dp)
                    .clickable {
                        input?.moreCast()
                    }.align(Alignment.CenterHorizontally),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = R.string.more),
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_arrow_down),
                    contentDescription = "더보기"
                )
            }
        }
    }
}

@Composable
fun MovieCastItem(
    modifier: Modifier = Modifier,
    cast: Cast
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.size(60.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            ),
            shape = MaterialTheme.shapes.medium,
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(cast.profileImage)
                        .error(R.drawable.ic_no_profile)
//                        .placeholder(R.drawable.ic_no_profile)
                        .apply {
                            crossfade(true)
                        }.build()
                ),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "영화 포스터",
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.width(Paddings.padding12))

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = cast.name,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(Paddings.padding4))

            Text(
                text = cast.character,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCastPreview(
    @PreviewParameter(CastsSampleProvider::class) casts: List<Cast>
) {
    ComposeMovieAppTheme {
        MovieCast(casts = casts)
    }
}