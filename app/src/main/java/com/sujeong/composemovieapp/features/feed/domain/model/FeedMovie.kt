package com.sujeong.composemovieapp.features.feed.domain.model

import com.sujeong.composemovieapp.features.common.domain.model.Movie
import com.sujeong.composemovieapp.features.common.domain.model.MovieGenre

data class FeedMovie(
    val genre: MovieGenre,
    val movies: List<Movie>
)