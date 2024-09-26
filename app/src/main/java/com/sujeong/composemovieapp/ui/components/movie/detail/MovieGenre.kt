package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import com.sujeong.composemovieapp.ui.theme.Shapes
import com.sujeong.composemovieapp.ui.theme.White
import com.sujeong.composemovieapp.ui.theme.labelSmallProminent

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MovieGenre(
    modifier: Modifier = Modifier,
    genres: List<String>
) {
    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(Paddings.padding4),
        verticalArrangement = Arrangement.spacedBy(Paddings.padding4)
    ) {
        genres.forEach {
            MovieGenreItem(it)
        }
    }
}

@Composable
fun MovieGenreItem(
    genre: String
) {
    AssistChip(
        modifier = Modifier.height(24.dp),
        enabled = false,
        onClick = { },
        label = {
            Text(
                text = genre,
                style = MaterialTheme.typography.labelSmallProminent
            )
        },
        shape = Shapes.large,
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.primary,
            labelColor = White,
            disabledContainerColor = MaterialTheme.colorScheme.primary,
            disabledLabelColor = White
        ),
        border = AssistChipDefaults.assistChipBorder(
            enabled = false,
            borderWidth = 0.dp
        )
    )
}

@Preview(showBackground = true)
@Composable
fun MovieGenrePreview() {
    ComposeMovieAppTheme {
        MovieGenre(
            genres = listOf("애니메이션", "가족", "드라마", "미스터리")
        )
    }
}