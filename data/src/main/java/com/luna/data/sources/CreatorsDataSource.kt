package com.luna.data.sources

import arrow.core.Either
import com.luna.domain.AppError
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story

interface CreatorsDataSource {

    suspend fun getCreators(): Either<AppError, List<MarvelItem>>

    suspend fun getCreatorById(creatorId: Int): Either<AppError, List<Creator>>

    suspend fun getComicsByCreatorId(creatorId: Int): Either<AppError, List<Comic>>

    suspend fun getEventsByCreatorId(creatorId: Int): Either<AppError, List<Event>>

    suspend fun getSeriesByCreatorId(creatorId: Int): Either<AppError, List<Series>>

    suspend fun getStoriesByCreatorId(creatorId: Int): Either<AppError, List<Story>>
}