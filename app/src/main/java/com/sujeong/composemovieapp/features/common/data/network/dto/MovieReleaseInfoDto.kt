package com.sujeong.composemovieapp.features.common.data.network.dto

import com.squareup.moshi.Json

data class MovieReleaseInfoDto(
    @Json(name = "iso_3166_1")
    val iosCode: String,
    @Json(name = "release_dates")
    val releaseDetails: List<MovieReleaseInfoDetailDto>
)
