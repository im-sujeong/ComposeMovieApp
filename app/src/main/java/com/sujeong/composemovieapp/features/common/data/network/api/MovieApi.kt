package com.sujeong.composemovieapp.features.common.data.network.api

import com.sujeong.composemovieapp.features.common.data.network.dto.MovieCreditsDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDetailDto
import com.sujeong.composemovieapp.library.network.BaseListResponseDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieReleaseInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("movie/popular?language=ko&page=1&region=kr")
    suspend fun fetchPopularMovies(): BaseListResponseDto<MovieDto>

    @GET("movie/now_playing?language=ko&page=1&region=kr")
    suspend fun fetchNowPlayingMovies(): BaseListResponseDto<MovieDto>

    @GET("movie/upcoming?language=ko&page=1&region=kr")
    suspend fun fetchUpcomingMovies(): BaseListResponseDto<MovieDto>

    @GET("movie/top_rated?language=ko&page=1&region=kr")
    suspend fun fetchTopRatedMovies(): BaseListResponseDto<MovieDto>

    @GET("movie/{movieId}?language=ko")
    suspend fun fetchMovieDetail(
        @Path("movieId") movieId: Int
    ): MovieDetailDto

    @GET("movie/{movieId}/credits?language=ko")
    suspend fun fetchMovieCredits(
        @Path("movieId") movieId: Int
    ): MovieCreditsDto

    @GET("movie/{movieId}/release_dates")
    suspend fun fetchMovieReleaseInfo(
        @Path("movieId") movieId: Int
    ): BaseListResponseDto<MovieReleaseInfoDto>

}