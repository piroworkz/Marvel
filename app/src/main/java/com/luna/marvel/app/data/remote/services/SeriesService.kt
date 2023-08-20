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

interface SeriesService {

    @GET("series")
    suspend fun getSeries(): MarvelNetworkResponse<RemoteSeries>

    @GET("series/{seriesId}")
    suspend fun getSeriesById(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteSeries>

    @GET("series/{seriesId}/characters")
    suspend fun getCharactersBySeriesId(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteCharacter>

    @GET("series/{seriesId}/comics")
    suspend fun getComicsBySeriesId(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteComic>

    @GET("series/{seriesId}/creators")
    suspend fun getCreatorsBySeriesId(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteCreators>

    @GET("series/{seriesId}/events")
    suspend fun getEventsBySeriesId(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteEvent>

    @GET("series/{seriesId}/stories")
    suspend fun getStoriesBySeriesId(@Path("seriesId") seriesId: Int): MarvelNetworkResponse<RemoteStories>
}