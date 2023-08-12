package com.luna.marvel.usecases.series

import com.luna.marvel.data.repositories.SeriesRepository
import javax.inject.Inject

class GetCreatorsBySeriesIdUseCase @Inject constructor(private val repository: SeriesRepository) {
    suspend operator fun invoke(seriesId: Int) = repository.getCreatorsBySeriesId(seriesId)
}