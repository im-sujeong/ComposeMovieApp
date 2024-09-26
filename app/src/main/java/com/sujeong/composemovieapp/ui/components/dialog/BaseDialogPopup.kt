package com.sujeong.composemovieapp.ui.components.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sujeong.composemovieapp.ui.components.dialog.components.DialogButton
import com.sujeong.composemovieapp.ui.components.dialog.components.DialogContent
import com.sujeong.composemovieapp.ui.model.DialogButtonType
import com.sujeong.composemovieapp.ui.model.DialogContentType
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

object DialogPopup

@Composable
fun BaseDialogPopup(
    modifier: Modifier = Modifier,
    title: String,
    dialogContent: DialogContentType,
    dialogButtons: List<DialogButtonType>
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(Paddings.padding24),
                color = MaterialTheme.colorScheme.onBackground
            )

            DialogContent(dialogContentType = dialogContent)
            DialogButton(dialogButtons = dialogButtons)
        }
    }
}

@Preview
@Composable
fun BaseDialogPopupPreview() {
    ComposeMovieAppTheme {
        BaseDialogPopup(
            title = "앱 정보",
            dialogContent = DialogContentType.Rating(
                rating = 4.0f
            ),
            dialogButtons = listOf(
                DialogButtonType.Secondary(
                    text = "취소",
                    onClick = { }
                ), DialogButtonType.Primary(
                    text = "확인",
                    onClick = { }
                )
            )
        )
        /*BaseDialogPopup(
            title = "앱 정보",
            dialogContent = DialogContentType.Text(
                text = "내용내용"
            ),
            dialogButtons = listOf(
                DialogButtonType.Secondary(
                    text = "취소",
                    onClick = { }
                ), DialogButtonType.Primary(
                    text = "확인",
                    onClick = { }
                )
            )
        )*/
    }
}