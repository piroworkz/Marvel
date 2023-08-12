package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface StoriesService {

    @POST("stories")
    suspend fun getStories(): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}")
    suspend fun getStoryById(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}/characters")
    suspend fun getCharactersByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}/comics")
    suspend fun getComicsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}/creators")
    suspend fun getCreatorsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}/events")
    suspend fun getEventsByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

    @POST("stories/{storyId}/series")
    suspend fun getSeriesByStoryId(@Path("storyId") storyId: Int): MarvelNetworkResponse<RemoteStories>

}