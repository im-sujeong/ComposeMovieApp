package com.sujeong.composemovieapp.features.common.domain.model

import androidx.annotation.StringRes
import com.sujeong.composemovieapp.R

enum class MovieGenre(
    @StringRes val genreTitleRes: Int,
    val genreId: Int
) {
    ACTION(
        R.string.genre_action,
        28
    ),
    ADVENTURE(
        R.string.genre_adventure,
        12
    ),
    ANIMATION(
        R.string.genre_animation,
        16
    ),
    COMEDY(
        R.string.genre_comedy,
        35
    ),
    CRIME(
        R.string.genre_crime,
        80
    ),
    DOCUMENTARY(
        R.string.genre_documentary,
        99
    ),
    DRAMA(
        R.string.genre_drama,
        18
    ),
    FAMILY(
        R.string.genre_family,
        10751
    ),
    FANTASY(
        R.string.genre_fantasy,
        14
    ),
    SCIENCE_FICTION(
        R.string.genre_science_fiction,
        878
    );

    companion object {
        fun toGenre(genreCode: Int): MovieGenre {
            return when (genreCode) {
                28 -> ACTION
                12 -> ADVENTURE
                16 -> ANIMATION
                35 -> COMEDY
                80 -> CRIME
                99 -> DOCUMENTARY
                18 -> DRAMA
                10751 -> FAMILY
                14 -> FANTASY
                878 -> SCIENCE_FICTION
                else -> ACTION
            }
        }
    }
}