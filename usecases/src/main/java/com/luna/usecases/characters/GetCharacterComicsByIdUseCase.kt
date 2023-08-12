package com.luna.usecases.characters

import com.luna.data.repositories.CharactersRepository
import javax.inject.Inject

class GetCharacterComicsByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int) = repository.getCharacterComicsById(characterId)
}