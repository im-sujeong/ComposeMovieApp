package com.sujeong.composemovieapp.features.common.data.network.dto

import com.squareup.moshi.Json

data class MovieCastDto(
    val id: Int,
    val name: String,
    val character: String,
    @Json(name = "profile_path")
    val profilePath: String?,
    @Json(name = "known_for_department")
    val part: String
)
