package com.sujeong.composemovieapp.ui.components.movie.sample

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.sujeong.composemovieapp.features.common.domain.model.MovieCertification
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail

class MovieDetailSampleProvider: PreviewParameterProvider<MovieDetail> {
    override val values: Sequence<MovieDetail>
        get() = sequenceOf(
            MovieDetail(
                id = 1,
                title = "영화 1",
                poster = "https://",
                rating = 9.1f,
                releaseDate = "2022.12.12",
                runtime = 120,
                genres = listOf("액션", "모험"),
                overview = "영화 1에 대한 설명입니다.",
                casts = emptyList(),
                tagline = "",
                certification = MovieCertification.All
            )
        )
}