package com.sujeong.composemovieapp.library.model

sealed interface Result<out D> {
    data class Success<out D>(val data: D): Result<D>
    data class Error<out D>(val error: AppError): Result<D>
}