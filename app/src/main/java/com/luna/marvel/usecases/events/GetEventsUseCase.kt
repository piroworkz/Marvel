package com.luna.marvel.usecases.events

import com.luna.marvel.data.repositories.EventsRepository
import javax.inject.Inject

class GetEventsUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend fun invoke() = repository.getEvents()
}