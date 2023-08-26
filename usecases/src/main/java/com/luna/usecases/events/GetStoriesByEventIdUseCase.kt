package com.luna.usecases.events

import com.luna.data.repositories.EventsRepository
import javax.inject.Inject

class GetStoriesByEventIdUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend operator fun invoke(eventId: Int) = repository.getStoriesByEventId(eventId)
}