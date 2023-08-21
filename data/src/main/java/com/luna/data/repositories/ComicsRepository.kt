package com.luna.data.repositories

import arrow.core.Either
import com.luna.data.sources.ComicsDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Story
import javax.inject.Inject

class ComicsRepository @Inject constructor(private val remote: ComicsDataSource) {

    suspend fun getComics(): Either<AppError, List<MarvelItem>> =
        remote.getComics()

    suspend fun getComicById(id: Int): Either<AppError, List<Comic>> =
        remote.getComicById(id)

    suspend fun getComicCharactersById(id: Int): Either<AppError, List<Character>> =
        remote.getComicCharactersById(id)

    suspend fun getComicCreatorsById(id: Int): Either<AppError, List<Creator>> =
        remote.getComicCreatorsById(id)

    suspend fun getComicEventsById(id: Int): Either<AppError, List<Event>> =
        remote.getComicEventsById(id)

    suspend fun getComicStoriesById(id: Int): Either<AppError, List<Story>> =
        remote.getComicStoriesById(id)

}