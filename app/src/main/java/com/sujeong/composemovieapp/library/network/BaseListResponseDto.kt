package com.sujeong.composemovieapp.library.network

data class BaseListResponseDto<T>(
    val results: List<T>
)