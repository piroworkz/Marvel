package com.luna.data.repositories

import arrow.core.Either
import com.luna.data.sources.StoriesDataSource
import com.luna.domain.AppError
import com.luna.domain.MarvelItem
import com.luna.domain.Stories
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val remote: StoriesDataSource) {

    suspend fun getStories(): Either<AppError, List<MarvelItem>> =
        remote.getStories()

    suspend fun getStoryById(storyId: Int): Either<AppError, List<Stories>> =
        remote.getStoryById(storyId)

    suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Stories>> =
        remote.getCharactersByStoryId(storyId)

    suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Stories>> =
        remote.getComicsByStoryId(storyId)

    suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Stories>> =
        remote.getCreatorsByStoryId(storyId)

    suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Stories>> =
        remote.getEventsByStoryId(storyId)

    suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Stories>> =
        remote.getSeriesByStoryId(storyId)
}