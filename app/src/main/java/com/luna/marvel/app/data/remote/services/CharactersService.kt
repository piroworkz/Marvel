package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface CharactersService {

    @POST("characters")
    suspend fun getCharacters(): MarvelNetworkResponse<RemoteCharacter>

    @POST("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

    @POST("characters/{characterId}/comics")
    suspend fun getCharacterComicsById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

    @POST("characters/{characterId}/events")
    suspend fun getCharacterEventsById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

    @POST("characters/{characterId}/series")
    suspend fun getCharacterSeriesById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

    @POST("characters/{characterId}/stories")
    suspend fun getCharacterStoriesById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

}