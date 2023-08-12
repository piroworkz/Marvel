package com.luna.marvel.usecases.stories

import com.luna.marvel.data.repositories.StoriesRepository
import javax.inject.Inject

class GetEventsByStoryIdUseCase @Inject constructor(private val repository: StoriesRepository) {
    suspend operator fun invoke(storyId: Int) = repository.getEventsByStoryId(storyId)
}