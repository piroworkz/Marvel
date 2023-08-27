package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeCreatorsService : CreatorsService {
    
    override suspend fun getCreators(): MarvelNetworkResponse<RemoteCreators> =
        buildResponseWith(fakeRemoteCreators)

    override suspend fun getCharacterById(creatorId: Int): MarvelNetworkResponse<RemoteCreators> =
        if (creatorId != 0) buildResponseWith(fakeRemoteCreators) else buildResponseWith(emptyList())

    override suspend fun getComicsByCreatorId(creatorId: Int): MarvelNetworkResponse<RemoteComic> =
        if (creatorId != 0) buildResponseWith(fakeRemoteComics) else buildResponseWith(emptyList())

    override suspend fun getEventsByCreatorId(creatorId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (creatorId != 0) buildResponseWith(fakeRemoteEvents) else buildResponseWith(emptyList())

    override suspend fun getSeriesByCreatorId(creatorId: Int): MarvelNetworkResponse<RemoteSeries> =
        if (creatorId != 0) buildResponseWith(fakeRemoteSeries) else buildResponseWith(emptyList())

    override suspend fun getStoriesByCreatorId(creatorId: Int): MarvelNetworkResponse<RemoteStories> =
        if (creatorId != 0) buildResponseWith(fakeRemoteStories) else buildResponseWith(emptyList())
}