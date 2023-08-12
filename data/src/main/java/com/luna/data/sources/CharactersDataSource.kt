package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character

interface CharactersDataSource {
    suspend fun getCharacters(): Either<AppError, List<Character>>

    suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>>

    suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Character>>

    suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Character>>

    suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Character>>

    suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Character>>
}