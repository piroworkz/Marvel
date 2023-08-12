package com.luna.data.repositories

import arrow.core.Either
import com.luna.data.sources.EventsDataSource
import com.luna.domain.AppError
import com.luna.domain.Event
import javax.inject.Inject

class EventsRepository @Inject constructor(private val remote: EventsDataSource) {

    suspend fun getEvents(): Either<AppError, List<Event>> =
        remote.getEvents()

    suspend fun getEventById(eventId: Int): Either<AppError, List<Event>> =
        remote.getEventById(eventId)

    suspend fun getCharactersByEventId(eventId: Int): Either<AppError, List<Event>> =
        remote.getCharactersByEventId(eventId)

    suspend fun getComicsByEventId(eventId: Int): Either<AppError, List<Event>> =
        remote.getComicsByEventId(eventId)

    suspend fun getCreatorsByEventId(eventId: Int): Either<AppError, List<Event>> =
        remote.getCreatorsByEventId(eventId)

    suspend fun getSeriesByEventId(eventId: Int): Either<AppError, List<Event>> =
        remote.getSeriesByEventId(eventId)

    suspend fun getStoriesByEventId(eventId: Int): Either<AppError, List<Event>> =
        remote.getStoriesByEventId(eventId)

}