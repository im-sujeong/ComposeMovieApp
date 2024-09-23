package com.sujeong.composemovieapp.features.common.data.network.api

import com.sujeong.composemovieapp.library.network.BaseListResponseDto
import com.sujeong.composemovieapp.features.common.data.network.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("discover/movie?language=ko&page=1&sort_by=popularity.desc")
    suspend fun fetchMovies(
        @Query("with_genres") genreId: Int
    ): BaseListResponseDto<MovieDto>
}