package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeSeriesService : SeriesService {

    override suspend fun getSeries(): MarvelNetworkResponse<RemoteSeries> =
        buildResponseWith(fakeRemoteSeries)

    override suspend fun getSeriesById(seriesId: Int): MarvelNetworkResponse<RemoteSeries> =
        if (seriesId != 0) buildResponseWith(fakeRemoteSeries.take(1)) else buildResponseWith(emptyList())

    override suspend fun getCharactersBySeriesId(seriesId: Int): MarvelNetworkResponse<RemoteCharacter> =
        if (seriesId != 0) buildResponseWith(fakeRemoteCharacters) else buildResponseWith(emptyList())

    override suspend fun getComicsBySeriesId(seriesId: Int): MarvelNetworkResponse<RemoteComic> =
        if (seriesId != 0) buildResponseWith(fakeRemoteComics) else buildResponseWith(emptyList())

    override suspend fun getCreatorsBySeriesId(seriesId: Int): MarvelNetworkResponse<RemoteCreators> =
        if (seriesId != 0) buildResponseWith(fakeRemoteCreators) else buildResponseWith(emptyList())

    override suspend fun getEventsBySeriesId(seriesId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (seriesId != 0) buildResponseWith(fakeRemoteEvents) else buildResponseWith(emptyList())

    override suspend fun getStoriesBySeriesId(seriesId: Int): MarvelNetworkResponse<RemoteStories> =
        if (seriesId != 0) buildResponseWith(fakeRemoteStories) else buildResponseWith(emptyList())
}