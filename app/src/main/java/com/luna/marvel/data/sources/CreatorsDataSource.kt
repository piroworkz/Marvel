package com.luna.marvel.data.sources

import arrow.core.Either
import com.luna.marvel.domain.AppError
import com.luna.marvel.domain.Creators

interface CreatorsDataSource {

    suspend fun getCreators(): Either<AppError, List<Creators>>

    suspend fun getCreatorById(creatorId: Int): Either<AppError, List<Creators>>

    suspend fun getComicsByCreatorId(creatorId: Int): Either<AppError, List<Creators>>

    suspend fun getEventsByCreatorId(creatorId: Int): Either<AppError, List<Creators>>

    suspend fun getSeriesByCreatorId(creatorId: Int): Either<AppError, List<Creators>>

    suspend fun getStoriesByCreatorId(creatorId: Int): Either<AppError, List<Creators>>
}