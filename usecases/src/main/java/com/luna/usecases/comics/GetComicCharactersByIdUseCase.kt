package com.luna.usecases.comics

import com.luna.data.repositories.ComicsRepository
import javax.inject.Inject

class GetComicCharactersByIdUseCase @Inject constructor(private val repository: ComicsRepository) {
    suspend operator fun invoke(id: Int) = repository.getComicCharactersById(id)
}