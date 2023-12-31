package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetEventsBySeriesIdUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getEventsBySeriesIdUseCase by lazy { GetEventsBySeriesIdUseCase(repository) }

    @Test
    fun `on success getEventsBySeriesIdUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(repository.getEventsBySeriesId(1)).thenReturn(expected)

            val actual = getEventsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsBySeriesIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getEventsBySeriesId(1)).thenReturn(expected)

            val actual = getEventsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}