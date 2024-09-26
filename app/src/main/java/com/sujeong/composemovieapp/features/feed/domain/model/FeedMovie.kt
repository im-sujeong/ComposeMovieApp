package com.sujeong.composemovieapp.features.feed.domain.model

data class FeedMovie(
    val feedMovieType: FeedMovieType,
    val movies: List<Movie>
)