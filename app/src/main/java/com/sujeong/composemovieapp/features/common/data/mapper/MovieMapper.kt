package com.sujeong.composemovieapp.features.common.data.mapper

import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDto
import com.sujeong.composemovieapp.features.common.domain.model.Movie

private val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original/"
fun MovieDto.toMovie() = Movie(
    id = id,
    title = title,
    poster = "$IMAGE_BASE_URL$poster",
    rating = voteAverage,
)