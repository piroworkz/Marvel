package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Event

interface EventsDataSource {
    suspend fun getEvents(): Either<AppError, List<Event>>

    suspend fun getEventById(eventId: Int): Either<AppError, List<Event>>

    suspend fun getCharactersByEventId(eventId: Int): Either<AppError, List<Event>>

    suspend fun getComicsByEventId(eventId: Int): Either<AppError, List<Event>>

    suspend fun getCreatorsByEventId(eventId: Int): Either<AppError, List<Event>>

    suspend fun getSeriesByEventId(eventId: Int): Either<AppError, List<Event>>

    suspend fun getStoriesByEventId(eventId: Int): Either<AppError, List<Event>>
}