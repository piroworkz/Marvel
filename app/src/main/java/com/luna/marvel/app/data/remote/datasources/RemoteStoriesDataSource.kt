package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.StoriesService
import com.luna.marvel.app.data.tryCatch
import com.luna.data.sources.StoriesDataSource

class RemoteStoriesDataSource(private val service: StoriesService) : StoriesDataSource {

    override suspend fun getStories() = tryCatch {
        service.getStories().data.results.map { it.toDomain() }
    }

    override suspend fun getStoryById(storyId: Int) = tryCatch {
        service.getStoryById(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getCharactersByStoryId(storyId: Int) = tryCatch {
        service.getCharactersByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getComicsByStoryId(storyId: Int) = tryCatch {
        service.getComicsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getCreatorsByStoryId(storyId: Int) = tryCatch {
        service.getCreatorsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getEventsByStoryId(storyId: Int) = tryCatch {
        service.getEventsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    override suspend fun getSeriesByStoryId(storyId: Int) = tryCatch {
        service.getSeriesByStoryId(storyId).data.results.map { it.toDomain() }
    }

}