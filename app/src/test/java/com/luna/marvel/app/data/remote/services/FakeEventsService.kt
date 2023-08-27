package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeEventsService : EventsService {

    override suspend fun getEvents(): MarvelNetworkResponse<RemoteEvent> =
        buildResponseWith(fakeRemoteEvents)

    override suspend fun getEventById(eventId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (eventId != 0) buildResponseWith(fakeRemoteEvents.take(1)) else buildResponseWith(emptyList())

    override suspend fun getCharactersByEventId(eventId: Int): MarvelNetworkResponse<RemoteCharacter> =
        if (eventId != 0) buildResponseWith(fakeRemoteCharacters) else buildResponseWith(emptyList())

    override suspend fun getComicsByEventId(eventId: Int): MarvelNetworkResponse<RemoteComic> =
        if (eventId != 0) buildResponseWith(fakeRemoteComics) else buildResponseWith(emptyList())

    override suspend fun getCreatorsByEventId(eventId: Int): MarvelNetworkResponse<RemoteCreators> =
        if (eventId != 0) buildResponseWith(fakeRemoteCreators) else buildResponseWith(emptyList())

    override suspend fun getSeriesByEventId(eventId: Int): MarvelNetworkResponse<RemoteSeries> =
        if (eventId != 0) buildResponseWith(fakeRemoteSeries) else buildResponseWith(emptyList())

    override suspend fun getStoriesByEventId(eventId: Int): MarvelNetworkResponse<RemoteStories> =
        if (eventId != 0) buildResponseWith(fakeRemoteStories) else buildResponseWith(emptyList())

}