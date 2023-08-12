package com.luna.usecases.characters

import arrow.core.Either
import com.luna.data.repositories.CharactersRepository
import com.luna.domain.AppError
import com.luna.domain.Character
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int): Either<AppError, List<Character>> = repository.getCharacterById(characterId)
}