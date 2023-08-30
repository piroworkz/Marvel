package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeStories
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetStoriesBySeriesIdUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getStoriesBySeriesIdUseCase by lazy { GetStoriesBySeriesIdUseCase(repository) }

    @Test
    fun `on success getStoriesBySeriesIdUseCase() should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(repository.getStoriesBySeriesId(1)).thenReturn(expected)

            val actual = getStoriesBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoriesBySeriesIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getStoriesBySeriesId(1)).thenReturn(expected)

            val actual = getStoriesBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}