package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface StoriesService {

    @GET("stories")
    suspend fun getStories(): MarvelNetworkResponse<RemoteStories>

    @GET("stories/{storyId}")
    suspend fun getStoryById(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @GET("stories/{storyId}/characters")
    suspend fun getCharactersByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteCharacter>

    @GET("stories/{storyId}/comics")
    suspend fun getComicsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("stories/{storyId}/creators")
    suspend fun getCreatorsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("stories/{storyId}/events")
    suspend fun getEventsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteEvent>

    @GET("stories/{storyId}/series")
    suspend fun getSeriesByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteSeries>

}