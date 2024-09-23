package com.sujeong.composemovieapp.ui.model

sealed class DialogButtonType(
    open val text: String,
    open val onClick: () -> Unit
) {
    data class Primary(
        override val text: String,
        override val onClick: () -> Unit
    ): DialogButtonType(text, onClick)

    data class Secondary(
        override val text: String,
        override val onClick: () -> Unit
    ): DialogButtonType(text, onClick)
}