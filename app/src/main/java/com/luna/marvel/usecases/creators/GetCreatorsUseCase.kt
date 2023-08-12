package com.luna.marvel.usecases.creators

import com.luna.marvel.data.repositories.CreatorsRepository
import javax.inject.Inject

class GetCreatorsUseCase @Inject constructor(private val repository: CreatorsRepository) {
    suspend operator fun invoke() = repository.getCreators()
}