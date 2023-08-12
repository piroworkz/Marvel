package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.EventsService
import com.luna.marvel.app.data.tryCatch
import javax.inject.Inject

class RemoteEventsDataSource @Inject constructor(private val service: EventsService) {

    suspend fun getEvents() = tryCatch {
        service.getEvents().data.results.map { it.toDomain() }
    }

    suspend fun getEventById(eventId: Int) = tryCatch {
        service.getEventById(eventId).data.results.map { it.toDomain() }
    }

    suspend fun getCharactersByEventId(eventId: Int) = tryCatch {
        service.getCharactersByEventId(eventId).data.results.map { it.toDomain() }
    }

    suspend fun getComicsByEventId(eventId: Int) = tryCatch {
        service.getComicsByEventId(eventId).data.results.map { it.toDomain() }
    }

    suspend fun getCreatorsByEventId(eventId: Int) = tryCatch {
        service.getCreatorsByEventId(eventId).data.results.map { it.toDomain() }
    }

    suspend fun getSeriesByEventId(eventId: Int) = tryCatch {
        service.getSeriesByEventId(eventId).data.results.map { it.toDomain() }
    }

    suspend fun getStoriesByEventId(eventId: Int) = tryCatch {
        service.getStoriesByEventId(eventId).data.results.map { it.toDomain() }
    }

}
