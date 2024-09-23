package com.sujeong.composemovieapp.library.model

sealed class AppError: Exception() {
    data object InvalidApiKey: AppError() {
        private fun readResolve(): Any = InvalidApiKey
    }

    data object ServerError: AppError() {
        private fun readResolve(): Any = ServerError
    }

    data object Unknown: AppError() {
        private fun readResolve(): Any = Unknown
    }
}