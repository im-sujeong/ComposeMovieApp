package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import com.sujeong.composemovieapp.ui.theme.bodyMediumLineHeight30

@Composable
fun MovieOverview(
    modifier: Modifier = Modifier,
    overview: String?
) {
    if(overview.isNullOrEmpty()) {
        return
    }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.movie_overview),
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(Paddings.padding16))

        Text(
            text = overview,
            style = MaterialTheme.typography.bodyMediumLineHeight30,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieOverviewPreview() {
    ComposeMovieAppTheme {
        MovieOverview(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            overview = "미스테리오의 계략으로 세상에 정체가 탄로난 스파이더맨 피터 파커는 하루 아침에 평범한 일상을 잃게 된다."
        )
    }
}