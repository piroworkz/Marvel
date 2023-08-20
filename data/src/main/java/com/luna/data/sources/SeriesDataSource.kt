package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creators
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story

interface SeriesDataSource {
    suspend fun getSeries(): Either<AppError, List<MarvelItem>>

    suspend fun getSeriesById(seriesId: Int): Either<AppError, List<Series>>

    suspend fun getCharactersBySeriesId(seriesId: Int): Either<AppError, List<Character>>

    suspend fun getComicsBySeriesId(seriesId: Int): Either<AppError, List<Comic>>

    suspend fun getCreatorsBySeriesId(seriesId: Int): Either<AppError, List<Creators>>

    suspend fun getEventsBySeriesId(seriesId: Int): Either<AppError, List<Event>>

    suspend fun getStoriesBySeriesId(seriesId: Int): Either<AppError, List<Story>>
}