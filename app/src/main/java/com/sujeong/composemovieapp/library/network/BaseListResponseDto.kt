package com.sujeong.composemovieapp.library.network

import com.squareup.moshi.Json

data class BaseListResponseDto<T>(
    val results: List<T>,
    @Json(name = "total_pages")
    val totalPages: Int?
)