package com.luna.marvel.data.repositories

import com.luna.marvel.data.sources.StoriesDataSource
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val remote: StoriesDataSource) {

    suspend fun getStories() =
        remote.getStories()

    suspend fun getStoryById(storyId: Int) =
        remote.getStoryById(storyId)

    suspend fun getCharactersByStoryId(storyId: Int) =
        remote.getCharactersByStoryId(storyId)

    suspend fun getComicsByStoryId(storyId: Int) =
        remote.getComicsByStoryId(storyId)

    suspend fun getCreatorsByStoryId(storyId: Int) =
        remote.getCreatorsByStoryId(storyId)

    suspend fun getEventsByStoryId(storyId: Int) =
        remote.getEventsByStoryId(storyId)

    suspend fun getSeriesByStoryId(storyId: Int) =
        remote.getSeriesByStoryId(storyId)
}