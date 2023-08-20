package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creators
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Stories

interface ComicsDataSource {
    suspend fun getComics(): Either<AppError, List<MarvelItem>>

    suspend fun getComicById(id: Int): Either<AppError, List<Comic>>

    suspend fun getComicCharactersById(id: Int): Either<AppError, List<Character>>

    suspend fun getComicCreatorsById(id: Int): Either<AppError, List<Creators>>

    suspend fun getComicEventsById(id: Int): Either<AppError, List<Event>>

    suspend fun getComicStoriesById(id: Int): Either<AppError, List<Stories>>
}