package com.sujeong.composemovieapp.features.feed.presentation.input

interface FeedViewModelInput {
    fun openDetail(movieId: Int)
    fun openAppInfo()
    fun refreshFeed()
}