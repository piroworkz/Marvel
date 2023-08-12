package com.luna.marvel.usecases.events

import com.luna.marvel.data.repositories.EventsRepository
import javax.inject.Inject

class GetStoriesByEventIdUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend fun invoke(eventId: Int) = repository.getStoriesByEventId(eventId)
}