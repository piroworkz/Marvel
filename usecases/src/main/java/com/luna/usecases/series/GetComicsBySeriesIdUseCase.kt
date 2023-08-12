package com.luna.usecases.series

import com.luna.data.repositories.SeriesRepository
import javax.inject.Inject

class GetComicsBySeriesIdUseCase @Inject constructor(private val repository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int) = repository.getComicsBySeriesId(seriesId)
}