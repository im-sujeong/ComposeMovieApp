package com.sujeong.composemovieapp.ui.components.movie.sample

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import com.sujeong.composemovieapp.features.feed.domain.model.FeedMovie
import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory

class FeedMovieSampleProvider : PreviewParameterProvider<FeedMovie> {
    override val values: Sequence<FeedMovie>
        get() = sequenceOf(
            FeedMovie(
                movieCategory = MovieCategory.POPULAR,
                movies = listOf(
                    Movie(
                        id = 1,
                        title = "영화 1",
                        poster = "https://",
                        rating = 9.1f
                    ), Movie(
                        id = 2,
                        title = "영화 2",
                        poster = "https://",
                        rating = 9.0f
                    ), Movie(
                        id = 3,
                        title = "영화 3",
                        poster = "https://",
                        rating = 1.1f
                    )
                )
            )
        )
}