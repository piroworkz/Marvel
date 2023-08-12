package com.luna.marvel.data.repositories

import com.luna.marvel.data.sources.SeriesDataSource
import javax.inject.Inject

class SeriesRepository @Inject constructor(private val remote: SeriesDataSource) {

    suspend fun getSeries() =
        remote.getSeries()

    suspend fun getSeriesById(seriesId: Int) =
        remote.getSeriesById(seriesId)

    suspend fun getCharactersBySeriesId(seriesId: Int) =
        remote.getCharactersBySeriesId(seriesId)

    suspend fun getComicsBySeriesId(seriesId: Int) =
        remote.getComicsBySeriesId(seriesId)

    suspend fun getCreatorsBySeriesId(seriesId: Int) =
        remote.getCreatorsBySeriesId(seriesId)

    suspend fun getEventsBySeriesId(seriesId: Int) =
        remote.getEventsBySeriesId(seriesId)

    suspend fun getStoriesBySeriesId(seriesId: Int) =
        remote.getStoriesBySeriesId(seriesId)
}