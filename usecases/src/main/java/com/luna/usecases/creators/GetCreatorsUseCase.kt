package com.luna.usecases.creators

import com.luna.data.repositories.CreatorsRepository
import javax.inject.Inject

class GetCreatorsUseCase @Inject constructor(private val repository: CreatorsRepository) {
    suspend operator fun invoke() = repository.getCreators()
}