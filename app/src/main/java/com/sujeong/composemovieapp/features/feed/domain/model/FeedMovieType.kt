package com.sujeong.composemovieapp.features.feed.domain.model

import androidx.annotation.StringRes
import com.sujeong.composemovieapp.R

enum class FeedMovieType(
    @StringRes val title: Int
) {
    POPULAR(R.string.feed_movie_popular),
    NOW_PLAYING(R.string.feed_movie_now_playing),
    UPCOMING(R.string.feed_movie_upcoming),
    TOP_RATED(R.string.feed_movie_top_rated)
}