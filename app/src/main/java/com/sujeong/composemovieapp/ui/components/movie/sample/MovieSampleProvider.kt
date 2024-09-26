package com.sujeong.composemovieapp.ui.components.movie.sample

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.sujeong.composemovieapp.features.feed.domain.model.Movie

class MovieSampleProvider: PreviewParameterProvider<Movie> {
    override val values: Sequence<Movie>
        get() = sequenceOf(
            Movie(
                id = 1,
                title = "영화 1",
                poster = "https://",
                rating = 9.1f
            )
        )
}