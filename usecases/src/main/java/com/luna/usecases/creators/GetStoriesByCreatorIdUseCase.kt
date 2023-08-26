package com.luna.usecases.creators

import com.luna.data.repositories.CreatorsRepository
import javax.inject.Inject

class GetStoriesByCreatorIdUseCase @Inject constructor(private val repository: CreatorsRepository) {
    suspend operator fun invoke(creatorId: Int) = repository.getStoriesByCreatorId(creatorId)
}