package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.luna.data.sources.CharactersDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story
import com.luna.marvel.app.data.tryCatch
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.fakeUnknownError

class FakeRemoteCharactersDataSource : CharactersDataSource {
    override suspend fun getCharacters(): Either<AppError, List<MarvelItem>> =
        tryCatch { fakeMarvelItems }

    override suspend fun getCharacterById(characterId: Int): Either<AppError, List<Character>> =
        if (characterId != 0) fakeCharacters.right() else fakeUnknownError.left()

    override suspend fun getCharacterComicsById(characterId: Int): Either<AppError, List<Comic>> =
        if (characterId != 0) fakeComics.right() else fakeUnknownError.left()

    override suspend fun getCharacterEventsById(characterId: Int): Either<AppError, List<Event>> =
        if (characterId != 0) fakeEvents.right() else fakeUnknownError.left()

    override suspend fun getCharacterSeriesById(characterId: Int): Either<AppError, List<Series>> =
        if (characterId != 0) fakeSeries.right() else fakeUnknownError.left()


    override suspend fun getCharacterStoriesById(characterId: Int): Either<AppError, List<Story>> =
        if (characterId != 0) fakeStories.right() else fakeUnknownError.left()
}