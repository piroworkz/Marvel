package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse

class FakeStoriesService : StoriesService {

    override suspend fun getStories(): MarvelNetworkResponse<RemoteStories> =
        buildResponseWith(fakeRemoteStories)

    override suspend fun getStoryById(storyId: Int): MarvelNetworkResponse<RemoteStories> =
        if (storyId != 0) buildResponseWith(fakeRemoteStories.take(1)) else buildResponseWith(emptyList())

    override suspend fun getCharactersByStoryId(storyId: Int): MarvelNetworkResponse<RemoteCharacter> =
        if (storyId != 0) buildResponseWith(fakeRemoteCharacters) else buildResponseWith(emptyList())

    override suspend fun getComicsByStoryId(storyId: Int): MarvelNetworkResponse<RemoteComic> =
        if (storyId != 0) buildResponseWith(fakeRemoteComics) else buildResponseWith(emptyList())

    override suspend fun getCreatorsByStoryId(storyId: Int): MarvelNetworkResponse<RemoteCreators> =
        if (storyId != 0) buildResponseWith(fakeRemoteCreators) else buildResponseWith(emptyList())

    override suspend fun getEventsByStoryId(storyId: Int): MarvelNetworkResponse<RemoteEvent> =
        if (storyId != 0) buildResponseWith(fakeRemoteEvents) else buildResponseWith(emptyList())

    override suspend fun getSeriesByStoryId(storyId: Int): MarvelNetworkResponse<RemoteSeries> =
        if (storyId != 0) buildResponseWith(fakeRemoteSeries) else buildResponseWith(emptyList())
}