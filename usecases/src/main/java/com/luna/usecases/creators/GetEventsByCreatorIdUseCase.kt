package com.luna.usecases.creators

import com.luna.data.repositories.CreatorsRepository
import javax.inject.Inject

class GetEventsByCreatorIdUseCase @Inject constructor(private val repository: CreatorsRepository) {
    suspend operator fun invoke(creatorId: Int) = repository.getEventsByCreatorId(creatorId)
}