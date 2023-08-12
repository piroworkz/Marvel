package com.luna.marvel.data.sources

import arrow.core.Either
import com.luna.marvel.domain.AppError
import com.luna.marvel.domain.Series

interface SeriesDataSource {
    suspend fun getSeries(): Either<AppError, List<Series>>

    suspend fun getSeriesById(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getCharactersBySeriesId(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getComicsBySeriesId(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getCreatorsBySeriesId(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getEventsBySeriesId(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getStoriesBySeriesId(seriesId: Int): Either<AppError, List<Series>>
}