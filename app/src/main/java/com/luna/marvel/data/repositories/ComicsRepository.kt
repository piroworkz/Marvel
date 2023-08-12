package com.luna.marvel.data.repositories

import arrow.core.Either
import com.luna.marvel.data.sources.ComicsDataSource
import com.luna.marvel.domain.AppError
import com.luna.marvel.domain.Comic
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val remote: ComicsDataSource) {

    suspend fun getComics(): Either<AppError, List<Comic>> =
        remote.getComics()

    suspend fun getComicById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicById(id)

    suspend fun getComicCharactersById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicCharactersById(id)

    suspend fun getComicCreatorsById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicCreatorsById(id)

    suspend fun getComicEventsById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicEventsById(id)

    suspend fun getComicStoriesById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicStoriesById(id)

}