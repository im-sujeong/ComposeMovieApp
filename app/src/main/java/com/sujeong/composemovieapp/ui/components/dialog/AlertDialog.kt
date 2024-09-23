package com.sujeong.composemovieapp.ui.components.dialog

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sujeong.composemovieapp.ui.model.DialogButtonType
import com.sujeong.composemovieapp.ui.model.DialogContentType

@Composable
fun DialogPopup.AlertDialog(
    @StringRes title: Int,
    @StringRes body: Int,
    @StringRes negativeButtonText: Int? = null,
    onNegativeButtonClick: (() -> Unit) = {},
    @StringRes positiveButtonText: Int,
    onPositiveButtonClick: () -> Unit,
) {
    AlertDialog(
        title = stringResource(id = title),
        body = stringResource(id = body),
        negativeButtonText = negativeButtonText?.let {
            stringResource(id = negativeButtonText)
        },
        onNegativeButtonClick = onNegativeButtonClick,
        positiveButtonText = stringResource(id = positiveButtonText),
        onPositiveButtonClick = onPositiveButtonClick
    )
}

@Composable
fun DialogPopup.AlertDialog(
    title: String,
    body: String,
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
        dialogContent = DialogContentType.Text(text = body),
        dialogButtons = buttons
    )
}