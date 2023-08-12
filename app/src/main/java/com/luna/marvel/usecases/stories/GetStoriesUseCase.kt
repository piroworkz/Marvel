package com.luna.marvel.usecases.stories

import com.luna.marvel.data.repositories.StoriesRepository
import javax.inject.Inject

class GetStoriesUseCase @Inject constructor(private val repository: StoriesRepository) {
    suspend operator fun invoke() = repository.getStories()
}