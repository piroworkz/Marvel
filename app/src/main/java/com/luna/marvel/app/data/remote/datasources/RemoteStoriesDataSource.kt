package com.luna.marvel.app.data.remote.datasources

import arrow.core.Either
import com.luna.data.sources.StoriesDataSource
import com.luna.domain.AppError
import com.luna.domain.Character
import com.luna.domain.Comic
import com.luna.domain.Creator
import com.luna.domain.Event
import com.luna.domain.MarvelItem
import com.luna.domain.Series
import com.luna.domain.Story
import com.luna.marvel.app.data.remote.services.StoriesService
import com.luna.marvel.app.data.tryCatch
import javax.inject.Inject

class RemoteStoriesDataSource @Inject constructor(private val service: StoriesService) :
    StoriesDataSource {

    override suspend fun getStories(): Either<AppError, List<MarvelItem>> = tryCatch {
        service.getStories().data.results.map { it.toDomainMarvelItem() }
            .filter { !it.thumbnail.path.contains("image_not_available") }
    }

    override suspend fun getStoryById(storyId: Int): Either<AppError, List<Story>> = tryCatch {
        service.getStoryById(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getCharactersByStoryId(storyId: Int): Either<AppError, List<Character>> =
        tryCatch {
            service.getCharactersByStoryId(storyId).data.results.map { it.toDomain() }
        }

    override suspend fun getComicsByStoryId(storyId: Int): Either<AppError, List<Comic>> =
        tryCatch {
            service.getComicsByStoryId(storyId).data.results.map { it.toDomain() }
        }

    override suspend fun getCreatorsByStoryId(storyId: Int): Either<AppError, List<Creator>> =
        tryCatch {
            service.getCreatorsByStoryId(storyId).data.results.map { it.toDomain() }
        }

    override suspend fun getEventsByStoryId(storyId: Int): Either<AppError, List<Event>> =
        tryCatch {
            service.getEventsByStoryId(storyId).data.results.map { it.toDomain() }
        }

    override suspend fun getSeriesByStoryId(storyId: Int): Either<AppError, List<Series>> =
        tryCatch {
            service.getSeriesByStoryId(storyId).data.results.map { it.toDomain() }
        }

}