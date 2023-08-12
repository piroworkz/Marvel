package com.luna.domain

sealed class AppError : Throwable() {
    data class NetworkError(val appError: String) : AppError()
    data class UnknownError(val appError: String) : AppError()
}
