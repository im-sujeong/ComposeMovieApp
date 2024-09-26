package com.sujeong.composemovieapp.features.detail.domain.model

import com.sujeong.composemovieapp.features.common.domain.model.MovieCertification

data class MovieDetail(
    val id: Int,
    val title: String,
    val poster: String,
    val rating: Float,
    val tagline: String?,
    val overview: String?,
    val releaseDate: String,
    val runtime: Int,
    val genres: List<String>,
    val casts: List<Cast>,
    val certification: MovieCertification
)
