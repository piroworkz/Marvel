package com.luna.marvel.usecases.characters

import com.luna.marvel.data.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacterSeriesByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int) = repository.getCharacterSeriesById(characterId)
}