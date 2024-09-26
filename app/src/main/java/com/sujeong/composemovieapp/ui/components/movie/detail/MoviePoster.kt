package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme

@Composable
fun MoviePosterBackground(
    modifier: Modifier = Modifier,
    posterUrl: String?
) {
    val gradient = Brush.verticalGradient(
        0.0f to MaterialTheme.colorScheme.background.copy(0.6f),
        0.9f to MaterialTheme.colorScheme.background,
    )
    
    Box(
        modifier = modifier.aspectRatio(0.75f)
    ){

        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(posterUrl)
                    .apply {
                        crossfade(true)
                    }.build()
            ),
            contentDescription = "포스터",
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradient)
        )
    }
}

@Composable
fun MoviePoster(
    modifier: Modifier = Modifier,
    posterUrl: String?
) {
    Card(
        modifier = modifier
            .width(180.dp)
            .height(240.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 10.dp
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(posterUrl)
                    .apply {
                        crossfade(true)
                    }.build()
            ),
            contentDescription = "포스터",
            contentScale = ContentScale.Crop
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun MoviePosterBackgroundPreview() {
    ComposeMovieAppTheme {
        MoviePosterBackground(
            posterUrl = ""
        )
    }
}

@Preview
@Composable
fun MoviePosterPreview() {
    ComposeMovieAppTheme {
        MoviePoster(posterUrl = "")
    }
}