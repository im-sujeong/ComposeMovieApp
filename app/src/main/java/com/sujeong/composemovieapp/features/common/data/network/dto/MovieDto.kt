package com.sujeong.composemovieapp.features.common.data.network.dto

import com.squareup.moshi.Json

data class MovieDto(
    val id: Int,
    val title: String,
    @Json(name = "vote_average")
    val voteAverage: Float,
    @Json(name = "poster_path")
    val poster: String?
)
