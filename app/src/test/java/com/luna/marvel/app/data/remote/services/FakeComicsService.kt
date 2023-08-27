package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeComicsService : ComicsService {

    override suspend fun getComics(): MarvelNetworkResponse<RemoteComic> =
        buildResponseWith(fakeRemoteComics)

    override suspend fun getComicById(comicId: Int): MarvelNetworkResponse<RemoteComic> =
        if (comicId != 0) buildResponseWith(fakeRemoteComics.take(1)) else buildResponseWith(emptyList())

    override suspend fun getComicCharactersById(comicId: Int): MarvelNetworkResponse<RemoteCharacter> =
        if (comicId != 0) buildResponseWith(fakeRemoteCharacters) else buildResponseWith(emptyList())

    override suspend fun getComicCreatorsById(comicId: Int): MarvelNetworkResponse<RemoteCreators> =
        if (comicId != 0) buildResponseWith(fakeRemoteCreators) else buildResponseWith(emptyList())

    override suspend fun getComicEventsById(comicId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (comicId != 0) buildResponseWith(fakeRemoteEvents) else buildResponseWith(emptyList())

    override suspend fun getComicStoriesById(comicId: Int): MarvelNetworkResponse<RemoteStories> =
        if (comicId != 0) buildResponseWith(fakeRemoteStories) else buildResponseWith(emptyList())
}