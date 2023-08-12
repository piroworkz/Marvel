package com.luna.marvel.usecases.comics

import com.luna.marvel.data.repositories.ComicsRepository
import javax.inject.Inject

class GetComicStoriesByIdUseCase @Inject constructor(private val repository: ComicsRepository) {
    suspend operator fun invoke(id: Int) = repository.getComicStoriesById(id)
}