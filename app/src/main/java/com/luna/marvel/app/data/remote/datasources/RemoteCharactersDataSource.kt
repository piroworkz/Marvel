package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.marvel.app.data.remote.services.CharactersService
import com.luna.marvel.app.data.tryCatch
import com.luna.data.sources.CharactersDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import javax.inject.Inject

class RemoteCharactersDataSource @Inject constructor(private val service: CharactersService) :
    CharactersDataSource {

    override suspend fun getCharacters(): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacters().data.results.map { it.toDomain() }
        }

    override suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacterById(characterId).data.results.map { it.toDomain() }
        }

    override suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacterComicsById(characterId).data.results.map { it.toDomain() }
        }

    override suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacterEventsById(characterId).data.results.map { it.toDomain() }
        }

    override suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacterEventsById(characterId).data.results.map { it.toDomain() }
        }

    override suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharacterEventsById(characterId).data.results.map { it.toDomain() }
        }

}