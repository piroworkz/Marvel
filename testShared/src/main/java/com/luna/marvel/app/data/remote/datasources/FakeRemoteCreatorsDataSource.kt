package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.CreatorsDataSource
import com.luna.domain.AppError
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.tryCatch

class FakeRemoteCreatorsDataSource : CreatorsDataSource {
    override suspend fun getCreators(): Either<AppError, List<MarvelItem>> =
        tryCatch { fakeMarvelItems }

    override suspend fun getCreatorById(creatorId: Int): Either<AppError, List<Creator>> =
        tryCatch {
            if (creatorId != 0) fakeCreators else emptyList()
        }

    override suspend fun getComicsByCreatorId(creatorId: Int): Either<AppError, List<Comic>> =
        tryCatch {
            if (creatorId != 0) fakeComics else emptyList()
        }

    override suspend fun getEventsByCreatorId(creatorId: Int): Either<AppError, List<Event>> =
        tryCatch {
            if (creatorId != 0) fakeEvents else emptyList()
        }

    override suspend fun getSeriesByCreatorId(creatorId: Int): Either<AppError, List<Series>> =
        tryCatch {
            if (creatorId != 0) fakeSeries else emptyList()
        }

    override suspend fun getStoriesByCreatorId(creatorId: Int): Either<AppError, List<Story>> =
        tryCatch {
            if (creatorId != 0) fakeStories else emptyList()
        }
}