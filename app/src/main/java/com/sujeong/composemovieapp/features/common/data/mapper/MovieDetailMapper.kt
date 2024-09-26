package com.sujeong.composemovieapp.features.common.data.mapper

import com.sujeong.composemovieapp.features.common.data.network.dto.MovieCastDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieCreditsDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDetailDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieReleaseInfoDto
import com.sujeong.composemovieapp.features.common.domain.model.MovieCertification
import com.sujeong.composemovieapp.features.detail.domain.model.Cast
import com.sujeong.composemovieapp.features.detail.domain.model.MovieDetail
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.math.round

private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/original/"

fun MovieDetailDto.toMovieDetail(
    creditsDto: MovieCreditsDto,
    releaseInfos: List<MovieReleaseInfoDto>
): MovieDetail {
    val originCountryReleaseInfo = releaseInfos.find {
        it.iosCode == originCountry[0]
    }?.releaseDetails?.get(0)

    val koreaReleaseInfo = releaseInfos.find {
        it.iosCode == "KR"
    }?.releaseDetails?.get(0)

    val localDateTime = koreaReleaseInfo?.releaseDate?.let {
        LocalDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME)
    } ?: originCountryReleaseInfo?.releaseDate?.let {
        LocalDateTime.parse(it, DateTimeFormatter.ISO_DATE_TIME)
    }

    val releaseDate = localDateTime?.format(
        DateTimeFormatter.ofPattern("yyyy.MM.dd")
    )

    val movieCertification = if(koreaReleaseInfo?.certification.isNullOrEmpty()) {
        MovieCertification.toMovieCertification(
            originCountryReleaseInfo?.certification ?: ""
        )
    }else {
        MovieCertification.toMovieCertification(
            koreaReleaseInfo?.certification ?: ""
        )
    }

    return MovieDetail(
        id = id,
        title = title,
        poster = "$IMAGE_BASE_URL$poster",
        tagline = tagline,
        genres = genres.map { it.name },
        rating = round(voteAverage/2 * 10) / 10,
        releaseDate = releaseDate ?: (this.releaseDate.replace("-", ".")),
        runtime = runtime,
        overview = overview?.replace(" ", "\u00A0"),
        casts = creditsDto.cast
            .filter {
                it.part == "Acting"
            }.map {
                it.toActor()
            },
        certification = movieCertification
    )
}

fun MovieCastDto.toActor(): Cast {
    return Cast(
        id = id,
        name = name,
        character = character,
        profileImage = "$IMAGE_BASE_URL$profilePath"
    )
}