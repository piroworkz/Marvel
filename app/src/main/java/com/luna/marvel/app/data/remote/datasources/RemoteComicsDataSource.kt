package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.ComicsService
import com.luna.marvel.app.data.tryCatch
import com.luna.marvel.data.sources.ComicsDataSource
import javax.inject.Inject

class RemoteComicsDataSource @Inject constructor(private val service: ComicsService) :
    ComicsDataSource {

    override suspend fun getComics() = tryCatch {
        service.getComics().data.results.map { it.toDomain() }
    }

    override suspend fun getComicById(id: Int) = tryCatch {
        service.getComicById(id).data.results.map { it.toDomain() }
    }

    override suspend fun getComicCharactersById(id: Int) = tryCatch {
        service.getComicCharactersById(id).data.results.map { it.toDomain() }
    }

    override suspend fun getComicCreatorsById(id: Int) = tryCatch {
        service.getComicCreatorsById(id).data.results.map { it.toDomain() }
    }

    override suspend fun getComicEventsById(id: Int) = tryCatch {
        service.getComicEventsById(id).data.results.map { it.toDomain() }
    }

    override suspend fun getComicStoriesById(id: Int) = tryCatch {
        service.getComicStoriesById(id).data.results.map { it.toDomain() }
    }
}