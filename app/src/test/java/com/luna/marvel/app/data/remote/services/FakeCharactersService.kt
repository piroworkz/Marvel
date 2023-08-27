package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeCharactersService : CharactersService {

    override suspend fun getCharacters(): MarvelNetworkResponse<RemoteCharacter> =
        buildResponseWith(fakeRemoteCharacters)

    override suspend fun getCharacterById(characterId: Int): MarvelNetworkResponse<RemoteCharacter> =
        if (characterId != 0) buildResponseWith(fakeRemoteCharacters.take(1)) else buildResponseWith(emptyList())

    override suspend fun getCharacterComicsById(characterId: Int): MarvelNetworkResponse<RemoteComic> =
        if (characterId != 0) buildResponseWith(fakeRemoteComics) else buildResponseWith(emptyList())

    override suspend fun getCharacterEventsById(characterId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (characterId != 0) buildResponseWith(fakeRemoteEvents) else buildResponseWith(emptyList())

    override suspend fun getCharacterSeriesById(characterId: Int): MarvelNetworkResponse<RemoteSeries> =
        if (characterId != 0) buildResponseWith(fakeRemoteSeries) else buildResponseWith(emptyList())

    override suspend fun getCharacterStoriesById(characterId: Int): MarvelNetworkResponse<RemoteStories> =
        if (characterId != 0) buildResponseWith(fakeRemoteStories) else buildResponseWith(emptyList())
}
