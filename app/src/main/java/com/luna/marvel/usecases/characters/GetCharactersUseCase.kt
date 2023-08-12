package com.luna.marvel.usecases.characters

import com.luna.marvel.data.repositories.CharactersRepository
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke() = repository.getCharacters()
}