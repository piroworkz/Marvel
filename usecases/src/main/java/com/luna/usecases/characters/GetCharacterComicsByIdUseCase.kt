package com.luna.usecases.characters

import arrow.core.Either
import com.luna.data.repositories.CharactersRepository
import com.luna.domain.AppError
import com.luna.domain.Comic
import javax.inject.Inject

class GetCharacterComicsByIdUseCase @Inject constructor(private val repository: CharactersRepository) {
    suspend operator fun invoke(characterId: Int): Either<AppError, List<Comic>> = repository.getCharacterComicsById(characterId)
}