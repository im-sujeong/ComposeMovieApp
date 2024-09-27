package com.sujeong.composemovieapp.ui.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun Poster(
    modifier: Modifier = Modifier,
    posterUrl: String,
    elevation: Dp = 6.dp,
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(
            defaultElevation = elevation
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

@Composable
fun BackgroundPoster(
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