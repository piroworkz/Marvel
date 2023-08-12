package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface CreatorsService {
    @POST("creators")
    suspend fun getCreators(): MarvelNetworkResponse<RemoteCreators>

    @POST("creators/{creatorId}")
    suspend fun getCharacterById(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @POST("creators/{creatorId}/comics")
    suspend fun getComicsByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @POST("creators/{creatorId}/events")
    suspend fun getEventsByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @POST("creators/{creatorId}/series")
    suspend fun getSeriesByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

    @POST("creators/{creatorId}/stories")
    suspend fun getStoriesByCreatorId(@Path("creatorId") creatorId: Int): MarvelNetworkResponse<RemoteCreators>

}