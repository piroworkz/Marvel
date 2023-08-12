package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface EventsService {

    @POST("events")
    suspend fun getEvents(): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}")
    suspend fun getEventById(): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}/characters")
    suspend fun getCharactersByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}/comics")
    suspend fun getComicsByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}/creators")
    suspend fun getCreatorsByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}/series")
    suspend fun getSeriesByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

    @POST("events/{eventId}/stories")
    suspend fun getStoriesByEventId(@Path("eventId") eventId: Int): MarvelNetworkResponse<RemoteEvent>

}