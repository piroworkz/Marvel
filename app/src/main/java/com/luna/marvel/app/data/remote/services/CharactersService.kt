package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersService {

    @GET("characters")
    suspend fun getCharacters(): MarvelNetworkResponse<RemoteCharacter>

    @GET("characters/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteCharacter>

    @GET("characters/{characterId}/comics")
    suspend fun getCharacterComicsById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("characters/{characterId}/events")
    suspend fun getCharacterEventsById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteEvent>

    @GET("characters/{characterId}/series")
    suspend fun getCharacterSeriesById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteSeries>

    @GET("characters/{characterId}/stories")
    suspend fun getCharacterStoriesById(@Path("characterId") characterId: Int): MarvelNetworkResponse<RemoteStories>

}