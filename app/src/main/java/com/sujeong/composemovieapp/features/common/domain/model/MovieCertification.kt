package com.sujeong.composemovieapp.features.common.domain.model

import androidx.annotation.StringRes
import com.sujeong.composemovieapp.R

sealed class MovieCertification(
    @StringRes val certificationLabel: Int? = null,
    open val originCertification: String = "-",
) {
    data object All: MovieCertification(
        R.string.movie_certification_all
    )

    data object Age12: MovieCertification(
        R.string.movie_certification_12
    )

    data object Age15: MovieCertification(
        R.string.movie_certification_15
    )

    data object Age19: MovieCertification(
        R.string.movie_certification_19
    )

    data class OriginCertification(
        override val originCertification: String
    ): MovieCertification(
        originCertification = originCertification
    )

    companion object {
        fun toMovieCertification(certification: String): MovieCertification {
            return when(certification) {
                "All", "ALL" -> All
                "12" -> Age12
                "15" -> Age15
                "19" -> Age19
                else -> OriginCertification(certification)
            }
        }
    }
}
