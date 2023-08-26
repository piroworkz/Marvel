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

interface EventsService {

    @GET("events")
    suspend fun getEvents(): MarvelNetworkResponse<RemoteEvent>

    @GET("events/{eventId}")
    suspend fun getEventById(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

    @GET("events/{eventId}/characters")
    suspend fun getCharactersByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteCharacter>

    @GET("events/{eventId}/comics")
    suspend fun getComicsByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("events/{eventId}/creators")
    suspend fun getCreatorsByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("events/{eventId}/series")
    suspend fun getSeriesByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteSeries>

    @GET("events/{eventId}/stories")
    suspend fun getStoriesByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteStories>

}