package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteCharacter
import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.RemoteCreators
import com.luna.marvel.app.data.remote.model.RemoteEvent
import com.luna.marvel.app.data.remote.model.RemoteStories
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicsService {

    @GET("comics")
    suspend fun getComics(): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}")
    suspend fun getComicById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}/characters")
    suspend fun getComicCharactersById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteCharacter>

    @GET("comics/{comicId}/creators")
    suspend fun getComicCreatorsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("comics/{comicId}/events")
    suspend fun getComicEventsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteEvent>

    @GET("comics/{comicId}/stories")
    suspend fun getComicStoriesById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteStories>

}