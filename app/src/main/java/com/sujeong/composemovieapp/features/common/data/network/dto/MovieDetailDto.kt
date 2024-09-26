package com.sujeong.composemovieapp.features.common.data.network.dto

import com.squareup.moshi.Json

data class MovieDetailDto(
    val id: Int,
    @Json(name = "poster_path")
    val poster: String,
    val tagline: String?,
    val title: String,
    val genres: List<MovieGenreDto>,
    @Json(name = "vote_average")
    val voteAverage: Float,
    @Json(name = "release_date")
    val releaseDate: String,
    val runtime: Int,
    val overview: String?,
    @Json(name = "origin_country")
    val originCountry: List<String>
)
