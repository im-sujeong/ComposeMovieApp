package com.sujeong.composemovieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme

@Preview
@Composable
fun RatingDialogPreview() {
    ComposeMovieAppTheme {
        DialogPopup.RatingDialog(
            title = "영화 평가",
            rating = 3.5f,
            negativeButtonText = "취소",
            onNegativeButtonClick = {

            },
            positiveButtonText = "완료",
            onPositiveButtonClick = {

            }
        )
    }
}

@Preview
@Composable
fun AlertDialogPreview() {
    ComposeMovieAppTheme {
        DialogPopup.AlertDialog(
            title = "앱 정보",
            body = "앱 정보 팝업",
            negativeButtonText = "??",
            positiveButtonText = "확인"
        ) {

        }
    }
}