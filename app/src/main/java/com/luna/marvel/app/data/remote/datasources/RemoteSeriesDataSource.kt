package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.SeriesService
import com.luna.marvel.app.data.tryCatch
import com.luna.data.sources.SeriesDataSource
import javax.inject.Inject

class RemoteSeriesDataSource @Inject constructor(private val service: SeriesService) :
    SeriesDataSource {

    override suspend fun getSeries() = tryCatch {
        service.getSeries().data.results.map { it.toDomainMarvelItem() }
    }

    override suspend fun getSeriesById(seriesId: Int) = tryCatch {
        service.getSeriesById(seriesId).data.results.map { it.toDomain() }
    }

    override suspend fun getCharactersBySeriesId(seriesId: Int) = tryCatch {
        service.getCharactersBySeriesId(seriesId).data.results.map { it.toDomain() }
    }

    override suspend fun getComicsBySeriesId(seriesId: Int) = tryCatch {
        service.getComicsBySeriesId(seriesId).data.results.map { it.toDomain() }
    }

    override suspend fun getCreatorsBySeriesId(seriesId: Int) = tryCatch {
        service.getCreatorsBySeriesId(seriesId).data.results.map { it.toDomain() }
    }

    override suspend fun getEventsBySeriesId(seriesId: Int) = tryCatch {
        service.getEventsBySeriesId(seriesId).data.results.map { it.toDomain() }
    }

    override suspend fun getStoriesBySeriesId(seriesId: Int) = tryCatch {
        service.getStoriesBySeriesId(seriesId).data.results.map { it.toDomain() }
    }

}