package com.luna.marvel.usecases.characters

import com.luna.marvel.data.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacterStoriesByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int) = repository.getCharacterStoriesById(characterId)
}