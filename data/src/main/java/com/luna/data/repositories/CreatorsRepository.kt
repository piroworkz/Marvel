package com.luna.data.repositories

import com.luna.data.sources.CreatorsDataSource
import javax.inject.Inject

class CreatorsRepository @Inject constructor(private val remote: CreatorsDataSource) {

    suspend fun getCreators() =
        remote.getCreators()

    suspend fun getCreatorById(creatorId: Int) =
        remote.getCreatorById(creatorId)

    suspend fun getComicsByCreatorId(creatorId: Int) =
        remote.getComicsByCreatorId(creatorId)

    suspend fun getEventsByCreatorId(creatorId: Int) =
        remote.getEventsByCreatorId(creatorId)

    suspend fun getSeriesByCreatorId(creatorId: Int) =
        remote.getSeriesByCreatorId(creatorId)

    suspend fun getStoriesByCreatorId(creatorId: Int) =
        remote.getStoriesByCreatorId(creatorId)
}