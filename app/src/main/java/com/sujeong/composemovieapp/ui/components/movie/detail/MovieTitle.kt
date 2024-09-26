package com.sujeong.composemovieapp.ui.components.movie.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun MovieTitle(
    modifier: Modifier = Modifier,
    title: String,
    tagline: String? = null
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(!tagline.isNullOrEmpty()) {
            Text(
                text = tagline,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(Paddings.padding8))
        }

        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieTitlePreview() {
    ComposeMovieAppTheme(
        darkTheme = true
    ) {
        MovieTitle(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            title = "스파이더맨 : 노 웨이 홈",
            tagline = "무너진 세계, 차원을 뛰어넘는 위협"
        )
    }
}