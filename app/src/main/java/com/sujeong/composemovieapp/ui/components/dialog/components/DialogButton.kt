package com.sujeong.composemovieapp.ui.components.dialog.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sujeong.composemovieapp.ui.components.buttons.PrimaryButtonSmall
import com.sujeong.composemovieapp.ui.components.buttons.SecondaryButtonSmall
import com.sujeong.composemovieapp.ui.model.DialogButtonType
import com.sujeong.composemovieapp.ui.theme.ComposeMovieAppTheme
import com.sujeong.composemovieapp.ui.theme.Paddings

@Composable
fun DialogButton(
    dialogButtons: List<DialogButtonType>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Paddings.padding36,
                bottom = Paddings.padding24
            ),
        horizontalArrangement = Arrangement.Center
    ) {
        dialogButtons.forEachIndexed { index, dialogButton ->
            if(index > 0) {
                Spacer(modifier = Modifier.width(Paddings.padding8))
            }

            when(dialogButton) {
                is DialogButtonType.Primary -> {
                    PrimaryButtonSmall(
                        text = dialogButton.text,
                        onClick = dialogButton.onClick
                    )
                }
                is DialogButtonType.Secondary -> {
                    SecondaryButtonSmall(
                        text = dialogButton.text,
                        onClick = dialogButton.onClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DialogButtonPreview() {
    ComposeMovieAppTheme {
        DialogButton(
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
    }
}