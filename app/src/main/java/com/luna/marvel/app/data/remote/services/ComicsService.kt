package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteComic
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST
import retrofit2.http.Path

interface ComicsService {

    @POST("comics")
    suspend fun getComics(): MarvelNetworkResponse<RemoteComic>

    @POST("comics/{comicId}")
    suspend fun getComicById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @POST("comics/{comicId}/characters")
    suspend fun getComicCharactersById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @POST("comics/{comicId}/creators")
    suspend fun getComicCreatorsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @POST("comics/{comicId}/events")
    suspend fun getComicEventsById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

    @POST("comics/{comicId}/stories")
    suspend fun getComicStoriesById(@Path("comicId") comicId: Int): MarvelNetworkResponse<RemoteComic>

}