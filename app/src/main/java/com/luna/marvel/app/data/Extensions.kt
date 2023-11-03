package com.luna.marvel.app.data

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.luna.domain.AppError
import retrofit2.HttpException
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
        is HttpException -> AppError.NetworkError

        is ConnectException -> AppError.NetworkError
        is SocketTimeoutException -> AppError.NetworkError
        is IOException -> AppError.NetworkError
        else -> AppError.UnknownError
    }
}

fun <E> List<E>?.isAvailable(block: (List<E>) -> Unit) {
    if (!this.isNullOrEmpty()) {
        block(this)
    } else {
        return
    }
}

val <E> List<E>?.isNotAvailable: AppError?
    get() = if (this.isNullOrEmpty()) {
        AppError.NotAvailable
    } else {
        null
    }