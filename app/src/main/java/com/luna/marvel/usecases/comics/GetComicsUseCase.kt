package com.luna.marvel.usecases.comics

import com.luna.marvel.data.repositories.ComicsRepository
import javax.inject.Inject

class GetComicsUseCase @Inject constructor(private val repository: ComicsRepository) {
    suspend operator fun invoke() = repository.getComics()
}