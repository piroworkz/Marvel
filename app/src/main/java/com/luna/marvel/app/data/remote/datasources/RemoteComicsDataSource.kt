package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.ComicsService
import com.luna.marvel.app.data.tryCatch
import javax.inject.Inject

class RemoteComicsDataSource @Inject constructor(private val service: ComicsService) {

    suspend fun getComics() = tryCatch {
        service.getComics().data.results.map { it.toDomain() }
    }

    suspend fun getComicById(id: Int) = tryCatch {
        service.getComicById(id).data.results.map { it.toDomain() }
    }

    suspend fun getComicCharactersById(id: Int) = tryCatch {
        service.getComicCharactersById(id).data.results.map { it.toDomain() }
    }

    suspend fun getComicCreatorsById(id: Int) = tryCatch {
        service.getComicCreatorsById(id).data.results.map { it.toDomain() }
    }

    suspend fun getComicEventsById(id: Int) = tryCatch {
        service.getComicEventsById(id).data.results.map { it.toDomain() }
    }

    suspend fun getComicStoriesById(id: Int) = tryCatch {
        service.getComicStoriesById(id).data.results.map { it.toDomain() }
    }
}