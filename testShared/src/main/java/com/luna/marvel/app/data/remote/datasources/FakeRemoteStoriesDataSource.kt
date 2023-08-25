package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.StoriesDataSource
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

class FakeRemoteStoriesDataSource : StoriesDataSource {
    override suspend fun getStories(): Either<AppError, List<MarvelItem>> =
        tryCatch { fakeMarvelItems }

    override suspend fun getStoryById(storyId: Int): Either<AppError, List<Story>> =
        tryCatch {
            if (storyId != 0) fakeStories else emptyList()
        }

    override suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Character>> =
        tryCatch {
            if (storyId != 0) fakeCharacters else emptyList()
        }

    override suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Comic>> =
        tryCatch {
            if (storyId != 0) fakeComics else emptyList()
        }

    override suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Creator>> =
        tryCatch {
            if (storyId != 0) fakeCreators else emptyList()
        }

    override suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Event>> =
        tryCatch {
            if (storyId != 0) fakeEvents else emptyList()
        }

    override suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Series>> =
        tryCatch {
            if (storyId != 0) fakeSeries else emptyList()
        }
}