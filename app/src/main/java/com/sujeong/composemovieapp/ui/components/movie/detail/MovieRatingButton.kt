package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.detail.presentation.input.MovieDetailViewModelInput
import com.sujeong.composemovieapp.ui.components.buttons.PrimaryButtonLarge
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun MovieRatingButton(
    modifier: Modifier = Modifier,
    input: MovieDetailViewModelInput? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.background.copy(alpha = 0f),
                        MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        PrimaryButtonLarge(
            modifier = Modifier
                .padding(Paddings.padding24),
            textId = R.string.add_rating,
            onClick = {
                input?.openRatingDialog()
            }
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun MovieRatingButtonPreview() {
    ComposeMovieAppTheme{
        MovieRatingButton()
    }
}