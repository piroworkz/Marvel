package com.luna.marvel.app.data.remote.datasources

import com.luna.data.sources.CreatorsDataSource
import com.luna.marvel.app.data.remote.services.CreatorsService
import com.luna.marvel.app.data.tryCatch
import javax.inject.Inject

class RemoteCreatorsDataSource @Inject constructor(private val service: CreatorsService) :
    CreatorsDataSource {

    override suspend fun getCreators() = tryCatch {
        service.getCreators().data.results.map { it.toDomainMarvelItem() }
            .filter { !it.thumbnail.path.contains("image_not_available") }
    }

    override suspend fun getCreatorById(creatorId: Int) = tryCatch {
        service.getCharacterById(creatorId).data.results.map { it.toDomain() }
    }

    override suspend fun getComicsByCreatorId(creatorId: Int) = tryCatch {
        service.getComicsByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    override suspend fun getEventsByCreatorId(creatorId: Int) = tryCatch {
        service.getEventsByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    override suspend fun getSeriesByCreatorId(creatorId: Int) = tryCatch {
        service.getSeriesByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

    override suspend fun getStoriesByCreatorId(creatorId: Int) = tryCatch {
        service.getStoriesByCreatorId(creatorId).data.results.map { it.toDomain() }
    }

}
