package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CreatorsService {
    @GET("creators")
    suspend fun getCreators(): MarvelNetworkResponse<RemoteCreators>

    @GET("creators/{creatorId}")
    suspend fun getCharacterById(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("creators/{creatorId}/comics")
    suspend fun getComicsByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("creators/{creatorId}/events")
    suspend fun getEventsByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("creators/{creatorId}/series")
    suspend fun getSeriesByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("creators/{creatorId}/stories")
    suspend fun getStoriesByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

}