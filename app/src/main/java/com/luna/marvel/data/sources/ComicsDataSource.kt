package com.luna.marvel.data.sources

import arrow.core.Either
import com.luna.marvel.domain.AppError
import com.luna.marvel.domain.Comic

interface ComicsDataSource {
    suspend fun getComics(): Either<AppError, List<Comic>>

    suspend fun getComicById(id: Int): Either<AppError, List<Comic>>

    suspend fun getComicCharactersById(id: Int): Either<AppError, List<Comic>>

    suspend fun getComicCreatorsById(id: Int): Either<AppError, List<Comic>>

    suspend fun getComicEventsById(id: Int): Either<AppError, List<Comic>>

    suspend fun getComicStoriesById(id: Int): Either<AppError, List<Comic>>
}