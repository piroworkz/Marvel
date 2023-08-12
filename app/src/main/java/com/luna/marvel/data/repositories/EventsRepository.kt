package com.luna.marvel.data.repositories

import com.luna.marvel.data.sources.EventsDataSource
import javax.inject.Inject

class EventsRepository @Inject constructor(private val remote: EventsDataSource) {

    suspend fun getEvents() =
        remote.getEvents()

    suspend fun getEventById(eventId: Int) =
        remote.getEventById(eventId)

    suspend fun getCharactersByEventId(eventId: Int) =
        remote.getCharactersByEventId(eventId)

    suspend fun getComicsByEventId(eventId: Int) =
        remote.getComicsByEventId(eventId)

    suspend fun getCreatorsByEventId(eventId: Int) =
        remote.getCreatorsByEventId(eventId)

    suspend fun getSeriesByEventId(eventId: Int) =
        remote.getSeriesByEventId(eventId)

    suspend fun getStoriesByEventId(eventId: Int) =
        remote.getStoriesByEventId(eventId)

}