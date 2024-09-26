package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import com.sujeong.composemovieapp.ui.components.movie.sample.MovieDetailSampleProvider
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun MovieInfo(
    modifier: Modifier = Modifier,
    movieDetail: MovieDetail
) {
    Row(
        modifier = modifier.fillMaxWidth(),
    ) {
        InfoItem(
            title = stringResource(id = R.string.movie_release_year),
            value = movieDetail.releaseDate
        )

        Spacer(modifier = Modifier.width(Paddings.padding36))

        InfoItem(
            title = stringResource(id = R.string.movie_runtime),
            value = stringResource(
                id = R.string.movie_runtime_format,
                movieDetail.runtime/60,
                movieDetail.runtime%60
            )
        )

        Spacer(modifier = Modifier.width(Paddings.padding36))

        InfoItem(
            title = stringResource(id = R.string.movie_certification),
            value = movieDetail.certification.certificationLabel?.let{
                stringResource(id = it)
            } ?: movieDetail.certification.originCertification
        )
    }
}

@Composable
fun InfoItem(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(Paddings.padding4))

        val lineBreak = LineBreak.Paragraph.copy(
            strategy = LineBreak.Strategy.HighQuality
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge
                .copy(
                    lineBreak = lineBreak
                ),
            color = MaterialTheme.colorScheme.onBackground,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieInfoPreview(
    @PreviewParameter(MovieDetailSampleProvider::class) movieDetail: MovieDetail
) {
    ComposeMovieAppTheme {
        MovieInfo(movieDetail = movieDetail)
    }
}