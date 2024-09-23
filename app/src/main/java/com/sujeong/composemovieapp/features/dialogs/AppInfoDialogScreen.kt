package com.sujeong.composemovieapp.features.dialogs

import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.sujeong.composemovieapp.R
import com.sujeong.composemovieapp.ui.components.dialog.AlertDialog
import com.sujeong.composemovieapp.ui.components.dialog.DialogPopup

@Composable
fun AppInfoDialogScreen(
    onDismiss: () -> Unit
) {
    DialogPopup.AlertDialog(
        title = R.string.app_info_dialog_title,
        body = R.string.app_info_dialog_body,
        positiveButtonText = R.string.confirm
    ) {
        onDismiss()
    }
}