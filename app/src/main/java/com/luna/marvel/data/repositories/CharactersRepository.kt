package com.luna.marvel.data.repositories

import arrow.core.Either
import com.luna.marvel.data.sources.CharactersDataSource
import com.luna.marvel.domain.AppError
import com.luna.marvel.domain.Character
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val remote: CharactersDataSource) {

    suspend fun getCharacters(): Either<AppError, List<Character>> =
        remote.getCharacters()

    suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterById(characterId)

    suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterComicsById(characterId)

    suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterEventsById(characterId)

    suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterSeriesById(characterId)

    suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterStoriesById(characterId)
}