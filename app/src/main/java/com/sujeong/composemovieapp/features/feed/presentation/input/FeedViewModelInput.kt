package com.sujeong.composemovieapp.features.feed.presentation.input

import com.sujeong.composemovieapp.features.feed.domain.model.MovieCategory

interface FeedViewModelInput {
    fun changeTheme()
    fun openDetail(movieId: Int)
    fun openAppInfo()
    fun refreshFeed()
    fun openMoreMovie(movieCategory: MovieCategory)
}