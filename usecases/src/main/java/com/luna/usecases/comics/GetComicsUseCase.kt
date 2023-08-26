package com.luna.usecases.comics

import com.luna.data.repositories.ComicsRepository
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(private val repository: ComicsRepository) {
    suspend operator fun invoke() = repository.getComics()
}