package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicsService {

    @GET("comics")
    suspend fun getComics(): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}")
    suspend fun getComicById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}/characters")
    suspend fun getComicCharactersById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}/creators")
    suspend fun getComicCreatorsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}/events")
    suspend fun getComicEventsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("comics/{comicId}/stories")
    suspend fun getComicStoriesById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

}