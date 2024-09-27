package com.sujeong.composemovieapp.features.feed.domain.model

data class FeedMovie(
    val movieCategory: MovieCategory,
    val movies: List<Movie>
)