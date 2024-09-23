package com.sujeong.composemovieapp.library

import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.adapter
import com.sujeong.composemovieapp.library.model.AppError
import com.sujeong.composemovieapp.library.network.BaseErrorResponse
import retrofit2.HttpException
import timber.log.Timber

@OptIn(ExperimentalStdlibApi::class)
fun Exception.toAppError(): AppError {
    Timber.e("Exception?! $this")
    return when(this) {
        is HttpException -> {
            response()?.let {
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter<BaseErrorResponse>()

                it.errorBody()?.string()?.let { errorBody ->
                    jsonAdapter.fromJson(errorBody)?.let { error ->
                        when(error.statusCode) {
                            7 -> AppError.InvalidApiKey
                            else -> AppError.ServerError
                        }
                    }
                } ?: kotlin.run {
                    AppError.Unknown
                }
            } ?: kotlin.run {
                AppError.Unknown
            }
        }
        else -> AppError.Unknown
    }
}