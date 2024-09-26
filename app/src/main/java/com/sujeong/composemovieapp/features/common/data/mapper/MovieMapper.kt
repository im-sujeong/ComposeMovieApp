package com.sujeong.composemovieapp.features.common.data.mapper

import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDto
import com.sujeong.composemovieapp.features.feed.domain.model.Movie
import kotlin.math.round

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500/"

fun MovieDto.toMovie() = Movie(
    id = id,
    title = title,
    poster = "$IMAGE_BASE_URL$poster",
    rating = round(voteAverage/2 * 10) / 10,
)