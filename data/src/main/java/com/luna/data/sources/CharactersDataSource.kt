package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Stories

interface CharactersDataSource {
    suspend fun getCharacters(): Either<AppError, List<MarvelItem>>

    suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>>

    suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Comic>>

    suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Event>>

    suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Series>>

    suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Stories>>
}