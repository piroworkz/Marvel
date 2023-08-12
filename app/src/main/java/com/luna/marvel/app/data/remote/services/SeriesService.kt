package com.luna.marvel.app.data.remote.services

import com.luna.marvel.app.data.remote.model.RemoteSeries
import com.luna.marvel.app.data.remote.model.common.MarvelNetworkResponse
import retrofit2.http.POST

interface SeriesService {

    @POST("series")
    suspend fun getSeries(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}")
    suspend fun getSeriesById(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}/characters")
    suspend fun getCharactersBySeriesId(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}/comics")
    suspend fun getComicsBySeriesId(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}/creators")
    suspend fun getCreatorsBySeriesId(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}/events")
    suspend fun getEventsBySeriesId(): MarvelNetworkResponse<RemoteSeries>

    @POST("series/{seriesId}/stories")
    suspend fun getStoriesBySeriesId(): MarvelNetworkResponse<RemoteSeries>
}