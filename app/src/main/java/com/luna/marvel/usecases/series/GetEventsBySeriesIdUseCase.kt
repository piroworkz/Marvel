package com.luna.marvel.usecases.series

import com.luna.marvel.data.repositories.SeriesRepository
import javax.inject.Inject

class GetEventsBySeriesIdUseCase @Inject constructor(private val repository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int) = repository.getEventsBySeriesId(seriesId)
}