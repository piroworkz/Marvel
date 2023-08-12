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

private fun Throwable.toAppError(): AppError {
    return when (this) {
        is HttpException -> AppError.NetworkError(message ?: "Hubo un error de comunicación, por favor intente más tarde.")
        is ConnectException -> AppError.NetworkError(message.toString())
        is SocketTimeoutException -> AppError.NetworkError("Hubo un error de comunicación, por favor intente más tarde.")
        is IOException -> AppError.NetworkError("Hubo un error de comunicación, por favor intente más tarde.")
        else -> AppError.UnknownError("Hubo un error de comunicación, por favor intente más tarde.")
    }
}
