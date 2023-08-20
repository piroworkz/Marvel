package com.luna.data.repositories

import arrow.core.Either
import com.luna.data.sources.CharactersDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Stories
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val remote: CharactersDataSource) {

    suspend fun getCharacters(): Either<AppError, List<MarvelItem>> =
        remote.getCharacters()

    suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>> =
        remote.getCharacterById(characterId)

    suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Comic>> =
        remote.getCharacterComicsById(characterId)

    suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Event>> =
        remote.getCharacterEventsById(characterId)

    suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Series>> =
        remote.getCharacterSeriesById(characterId)

    suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Stories>> =
        remote.getCharacterStoriesById(characterId)
}