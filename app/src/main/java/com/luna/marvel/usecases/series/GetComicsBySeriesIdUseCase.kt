package com.luna.marvel.usecases.series

import com.luna.marvel.data.repositories.SeriesRepository
import javax.inject.Inject

class GetComicsBySeriesIdUseCase @Inject constructor(private val repository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int) = repository.getComicsBySeriesId(seriesId)
}