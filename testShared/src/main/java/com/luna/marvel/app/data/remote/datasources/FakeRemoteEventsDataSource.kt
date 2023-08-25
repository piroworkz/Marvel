package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.EventsDataSource
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

class FakeRemoteEventsDataSource : EventsDataSource {
    override suspend fun getEvents(): Either<AppError, List<MarvelItem>> =
        tryCatch { fakeMarvelItems }

    override suspend fun getEventById(eventId: Int): Either<AppError, List<Event>> =
        tryCatch {
            if (eventId == 1) fakeEvents else emptyList()
        }

    override suspend fun getCharactersByEventId(eventId: Int): Either<AppError, List<Character>> =
        tryCatch {
            if (eventId == 1) fakeCharacters else emptyList()
        }

    override suspend fun getComicsByEventId(eventId: Int): Either<AppError, List<Comic>> =
        tryCatch {
            if (eventId == 1) fakeComics else emptyList()
        }

    override suspend fun getCreatorsByEventId(eventId: Int): Either<AppError, List<Creator>> =
        tryCatch {
            if (eventId == 1) fakeCreators else emptyList()
        }

    override suspend fun getSeriesByEventId(eventId: Int): Either<AppError, List<Series>> =
        tryCatch {
            if (eventId == 1) fakeSeries else emptyList()
        }

    override suspend fun getStoriesByEventId(eventId: Int): Either<AppError, List<Story>> =
        tryCatch {
            if (eventId == 1) fakeStories else emptyList()
        }
}