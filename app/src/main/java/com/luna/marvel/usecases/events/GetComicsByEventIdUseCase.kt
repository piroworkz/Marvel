package com.luna.marvel.usecases.events

import com.luna.marvel.data.repositories.EventsRepository
import javax.inject.Inject

class GetComicsByEventIdUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend fun invoke(eventId: Int) = repository.getComicsByEventId(eventId)
}