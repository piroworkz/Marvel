package com.luna.marvel.app.data.remote.datasources

import com.luna.data.sources.CharactersDataSource
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.tryCatch

class FakeRemoteCharactersDataSource : CharactersDataSource {

    override suspend fun getCharacters() =
        tryCatch { fakeMarvelItems }

    override suspend fun getCharacterById(characterId: Int) =
        tryCatch {
            if (characterId != 0) fakeCharacters else emptyList()
        }

    override suspend fun getCharacterComicsById(characterId: Int) =
        tryCatch {
            if (characterId != 0) fakeComics else emptyList()
        }

    override suspend fun getCharacterEventsById(characterId: Int) =
        tryCatch {
            if (characterId != 0) fakeEvents else emptyList()
        }

    override suspend fun getCharacterSeriesById(characterId: Int) =
        tryCatch {
            if (characterId != 0) fakeSeries else emptyList()
        }


    override suspend fun getCharacterStoriesById(characterId: Int) =
        tryCatch {
            if (characterId != 0) fakeStories else emptyList()
        }
}