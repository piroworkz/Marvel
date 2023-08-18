package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.StoriesDataSource
import com.luna.domain.AppError
import com.luna.domain.MarvelItem
import com.luna.domain.Stories
import com.luna.marvel.app.data.remote.services.StoriesService
import com.luna.marvel.app.data.tryCatch

class RemoteStoriesDataSource(private val service: StoriesService) : StoriesDataSource {

    override suspend fun getStories(): Either<AppError, List<MarvelItem>> = tryCatch {
        service.getStories().data.results.map { it.toDomainMarvelItem() }
    }

    override suspend fun getStoryById(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getStoryById(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getCharactersByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getComicsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getCreatorsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getEventsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Stories>> = tryCatch {
        service.getSeriesByStoryId(storyId).data.results.map { it.toDomain() }
    }

}