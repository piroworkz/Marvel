package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story

interface StoriesDataSource {
    suspend fun getStories(): Either<AppError, List<MarvelItem>>

    suspend fun getStoryById(storyId: Int): Either<AppError, List<Story>>

    suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Character>>

    suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Comic>>

    suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Creator>>

    suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Event>>

    suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Series>>
}