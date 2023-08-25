package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.SeriesDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.tryCatch

class FakeRemoteSeriesDataSource : SeriesDataSource {
    override suspend fun getSeries(): Either<AppError, List<MarvelItem>> =
        tryCatch { fakeMarvelItems }

    override suspend fun getSeriesById(seriesId: Int): Either<AppError, List<Series>> =
        tryCatch {
            if (seriesId != 0) fakeSeries else emptyList()
        }

    override suspend fun getCharactersBySeriesId(seriesId: Int): Either<AppError, List<Character>> =
        tryCatch {
            if (seriesId != 0) fakeCharacters else emptyList()
        }

    override suspend fun getComicsBySeriesId(seriesId: Int): Either<AppError, List<Comic>> =
        tryCatch {
            if (seriesId != 0) fakeComics else emptyList()
        }

    override suspend fun getCreatorsBySeriesId(seriesId: Int): Either<AppError, List<Creator>> =
        tryCatch {
            if (seriesId != 0) fakeCreators else emptyList()
        }

    override suspend fun getEventsBySeriesId(seriesId: Int): Either<AppError, List<Event>> =
        tryCatch {
            if (seriesId != 0) fakeEvents else emptyList()
        }

    override suspend fun getStoriesBySeriesId(seriesId: Int): Either<AppError, List<Story>> =
        tryCatch {
            if (seriesId != 0) fakeStories else emptyList()
        }
}