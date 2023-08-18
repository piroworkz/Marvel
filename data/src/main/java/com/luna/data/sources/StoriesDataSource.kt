package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.MarvelItem
import com.luna.domain.Stories

interface StoriesDataSource {
    suspend fun getStories(): Either<AppError, List<MarvelItem>>

    suspend fun getStoryById(storyId: Int): Either<AppError, List<Stories>>

    suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Stories>>

    suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Stories>>

    suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Stories>>

    suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Stories>>

    suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Stories>>
}