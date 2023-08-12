package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.CreatorsService
import com.luna.marvel.app.data.tryCatch
import javax.inject.Inject

class RemoteCreatorsDataSource @Inject constructor(private val service: CreatorsService) {

    suspend fun getCreators() = tryCatch {
        service.getCreators().data.results.map { it.toDomain() }
    }

    suspend fun getCreatorById(creatorId: Int) = tryCatch {
        service.getCharacterById(creatorId).data.results.map { it.toDomain() }
    }

    suspend fun getComicsByCreatorId(creatorId: Int) = tryCatch {
        service.getComicsByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    suspend fun getEventsByCreatorId(creatorId: Int) = tryCatch {
        service.getEventsByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    suspend fun getSeriesByCreatorId(creatorId: Int) = tryCatch {
        service.getSeriesByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    suspend fun getStoriesByCreatorId(creatorId: Int) = tryCatch {
        service.getStoriesByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

}
