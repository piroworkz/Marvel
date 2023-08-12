package com.luna.marvel.usecases.creators

import com.luna.marvel.data.repositories.CreatorsRepository
import javax.inject.Inject

class GetSeriesByCreatorIdUseCase @Inject constructor(private val repository: CreatorsRepository) {
    suspend operator fun invoke(creatorId: Int) = repository.getSeriesByCreatorId(creatorId)
}