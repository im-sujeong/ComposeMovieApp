package com.sujeong.composemovieapp.ui.components.movie.sample

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.sujeong.composemovieapp.features.detail.domain.model.Cast

class CastsSampleProvider: PreviewParameterProvider<List<Cast>> {
    override val values: Sequence<List<Cast>>
        get() = sequenceOf(
            listOf(
                Cast(
                    id = 1,
                    name = "배우 1",
                    profileImage = "",
                    character = "캐릭터 1"
                ),
                Cast(
                    id = 2,
                    name = "배우 2",
                    profileImage = "",
                    character = "캐릭터 2"
                ),
                Cast(
                    id = 3,
                    name = "배우 3",
                    profileImage = "",
                    character = "캐릭터 3"
                )
            )
        )
}