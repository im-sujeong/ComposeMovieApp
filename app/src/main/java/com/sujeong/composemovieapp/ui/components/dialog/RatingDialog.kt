package com.sujeong.composemovieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.sujeong.composemovieapp.ui.model.DialogButtonType
import com.sujeong.composemovieapp.ui.model.DialogContentType

@Composable
fun DialogPopup.RatingDialog(
    title: String,
    rating: Float = 5f,
    negativeButtonText: String? = null,
    onNegativeButtonClick: (() -> Unit) = {},
    positiveButtonText: String,
    onPositiveButtonClick: () -> Unit,
) {
    val buttons = mutableListOf<DialogButtonType>()

    if(negativeButtonText != null) {
        buttons.add(
            DialogButtonType.Secondary(
                text = negativeButtonText,
                onClick = onNegativeButtonClick
            )
        )
    }

    buttons.add(
        DialogButtonType.Primary(
            text = positiveButtonText,
            onClick = onPositiveButtonClick
        )
    )

    BaseDialogPopup(
        title = title,
        dialogContent = DialogContentType.Rating(rating),
        dialogButtons = buttons
    )
}