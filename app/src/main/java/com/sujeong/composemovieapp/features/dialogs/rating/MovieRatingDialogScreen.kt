package com.sujeong.composemovieapp.features.dialogs.rating

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.ui.components.dialog.DialogPopup
import com.sujeong.composemovieapp.ui.components.dialog.RatingDialog

@Composable
fun MovieRatingDialogScreen(
    onDismiss: () -> Unit
) {
    DialogPopup.RatingDialog(
        title = stringResource(id = R.string.movie_rating_dialog_title),
        negativeButtonText = stringResource(id = R.string.cancel),
        onNegativeButtonClick = {

        },
        positiveButtonText = stringResource(id = R.string.confirm),
        onPositiveButtonClick = {

        }
    )
}