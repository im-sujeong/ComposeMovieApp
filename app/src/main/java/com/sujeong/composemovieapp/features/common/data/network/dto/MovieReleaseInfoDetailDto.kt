package com.sujeong.composemovieapp.features.common.data.network.dto

import com.squareup.moshi.Json

data class MovieReleaseInfoDetailDto(
    val certification: String,
    @Json(name = "release_date")
    val releaseDate: String,
)
