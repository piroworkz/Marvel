package com.luna.testshared

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.luna.domain.AppError
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException

suspend fun <T> tryCatch(action: suspend () -> T): Either<AppError, T> = try {
    action().right()
} catch (e: Exception) {
    e.toAppError().left()
}

fun Throwable.toAppError(): AppError {
    return when (this) {
        is ConnectException -> AppError.NetworkError
        is SocketTimeoutException -> AppError.NetworkError
        is IOException -> AppError.NetworkError
        else -> AppError.UnknownError
    }
}