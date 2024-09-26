package com.sujeong.composemovieapp.ui.components.dialog.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.ui.components.RatingBar
import com.sujeong.composemovieapp.ui.model.DialogContentType
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings
import com.sujeong.composemovieapp.ui.theme.bodyMediumLineHeight30

@Composable
fun DialogContent(
    dialogContentType: DialogContentType
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        when(dialogContentType) {
            is DialogContentType.Rating -> {
                RatingBar(
                    rating = dialogContentType.rating,
                )
            }

            is DialogContentType.Text -> {
                Text(
                    modifier = Modifier.padding(
                        horizontal = Paddings.padding24
                    ),
                    text = dialogContentType.textId?.let {
                        stringResource(id = it)
                    } ?: dialogContentType.text,
                    style = MaterialTheme.typography.bodyMediumLineHeight30,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogContentPreview() {
    ComposeMovieAppTheme() {
        DialogContent(
//            dialogContentType = DialogContentType.Rating(2.5f)
            dialogContentType = DialogContentType.Text(
                text = "TMDB(themoviedb) API를 사용하여 간단한 영화 정보를 제공하는 앱입니다."
            )
        )
    }
}