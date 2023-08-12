package com.luna.marvel.app.data.remote.datasources

import com.luna.marvel.app.data.remote.services.StoriesService
import com.luna.marvel.app.data.tryCatch

class RemoteStoriesDataSource(private val service: StoriesService) {

    suspend fun getStories() = tryCatch {
        service.getStories().data.results.map { it.toDomain() }
    }

    suspend fun getStoryById(storyId: Int) = tryCatch {
        service.getStoryById(storyId).data.results.map { it.toDomain() }
    }

    suspend fun getCharactersByStoryId(storyId: Int) = tryCatch {
        service.getCharactersByStoryId(storyId).data.results.map { it.toDomain() }
    }

    suspend fun getComicsByStoryId(storyId: Int) = tryCatch {
        service.getComicsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    suspend fun getCreatorsByStoryId(storyId: Int) = tryCatch {
        service.getCreatorsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    suspend fun getEventsByStoryId(storyId: Int) = tryCatch {
        service.getEventsByStoryId(storyId).data.results.map { it.toDomain() }
    }

    suspend fun getSeriesByStoryId(storyId: Int) = tryCatch {
        service.getSeriesByStoryId(storyId).data.results.map { it.toDomain() }
    }

}