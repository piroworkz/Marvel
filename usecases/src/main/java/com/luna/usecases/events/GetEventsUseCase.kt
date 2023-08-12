package com.luna.usecases.events

import com.luna.data.repositories.EventsRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend fun invoke() = repository.getEvents()
}