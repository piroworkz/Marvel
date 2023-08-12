package com.luna.usecases.stories

import com.luna.data.repositories.StoriesRepository
import javax.inject.Inject

class GetCreatorsByStoryIdUseCase @Inject constructor(private val repository: StoriesRepository) {
    suspend operator fun invoke(storyId: Int) = repository.getCreatorsByStoryId(storyId)
}