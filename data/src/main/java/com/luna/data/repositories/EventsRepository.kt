package com.luna.data.repositories

import arrow.core.Either
import com.luna.data.sources.EventsDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creators
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Stories
import javax.inject.Inject

class EventsRepository @Inject constructor(private val remote: EventsDataSource) {

    suspend fun getEvents(): Either<AppError, List<MarvelItem>> =
        remote.getEvents()

    suspend fun getEventById(eventId: Int): Either<AppError, List<Event>> =
        remote.getEventById(eventId)

    suspend fun getCharactersByEventId(eventId: Int): Either<AppError, List<Character>> =
        remote.getCharactersByEventId(eventId)

    suspend fun getComicsByEventId(eventId: Int): Either<AppError, List<Comic>> =
        remote.getComicsByEventId(eventId)

    suspend fun getCreatorsByEventId(eventId: Int): Either<AppError, List<Creators>> =
        remote.getCreatorsByEventId(eventId)

    suspend fun getSeriesByEventId(eventId: Int): Either<AppError, List<Series>> =
        remote.getSeriesByEventId(eventId)

    suspend fun getStoriesByEventId(eventId: Int): Either<AppError, List<Stories>> =
        remote.getStoriesByEventId(eventId)

}