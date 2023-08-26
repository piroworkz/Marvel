package com.luna.domain

sealed class AppError(val appError: String) : Throwable() {
    data object NetworkError : AppError(COM_MESSAGE)
    data object UnknownError : AppError(COM_MESSAGE)
    data object NotAvailable : AppError(NOT_AVAILABLE)

    companion object {
        private const val COM_MESSAGE = "There was a communication error, please try again later."
        private const val NOT_AVAILABLE = "NO RESULTS AVAILABLE"
    }
}
