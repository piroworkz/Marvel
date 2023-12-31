package com.luna.data.repositories

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
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val remote: StoriesDataSource) {

    suspend fun getStories(): Either<AppError, List<MarvelItem>> =
        remote.getStories()

    suspend fun getStoryById(storyId: Int): Either<AppError, List<Story>> =
        remote.getStoryById(storyId)

    suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Character>> =
        remote.getCharactersByStoryId(storyId)

    suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Comic>> =
        remote.getComicsByStoryId(storyId)

    suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Creator>> =
        remote.getCreatorsByStoryId(storyId)

    suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Event>> =
        remote.getEventsByStoryId(storyId)

    suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Series>> =
        remote.getSeriesByStoryId(storyId)
}