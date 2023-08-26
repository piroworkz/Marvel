package com.luna.usecases.characters

import com.luna.data.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacterEventsByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int) = repository.getCharacterEventsById(characterId)
}