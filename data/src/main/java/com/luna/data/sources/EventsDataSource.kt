package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creators
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story

interface EventsDataSource {
    suspend fun getEvents(): Either<AppError, List<MarvelItem>>

    suspend fun getEventById(eventId: Int): Either<AppError, List<Event>>

    suspend fun getCharactersByEventId(eventId: Int): Either<AppError, List<Character>>

    suspend fun getComicsByEventId(eventId: Int): Either<AppError, List<Comic>>

    suspend fun getCreatorsByEventId(eventId: Int): Either<AppError, List<Creators>>

    suspend fun getSeriesByEventId(eventId: Int): Either<AppError, List<Series>>

    suspend fun getStoriesByEventId(eventId: Int): Either<AppError, List<Story>>
}