package com.luna.usecases.events

import com.luna.data.repositories.EventsRepository
import javax.inject.Inject

class GetCreatorsByEventIdUseCase @Inject constructor(private val repository: EventsRepository) {
    suspend fun invoke(eventId: Int) = repository.getCreatorsByEventId(eventId)
}