package com.sujeong.composemovieapp.ui.model

import androidx.annotation.StringRes

sealed class DialogContentType(
    @StringRes open val textId: Int? = null,
    open val text: String = ""
) {
    data class Text(
        @StringRes override val textId: Int? = null,
        override val text: String = ""
    ): DialogContentType(textId, text)

    data class Rating(
        val rating: Float
    ): DialogContentType()
}