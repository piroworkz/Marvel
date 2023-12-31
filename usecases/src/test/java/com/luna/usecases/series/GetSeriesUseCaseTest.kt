package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeMarvelItems
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetSeriesUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getSeriesUseCase by lazy { GetSeriesUseCase(repository) }

    @Test
    fun `on success getSeriesUseCase() should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(repository.getSeries()).thenReturn(expected)

            val actual = getSeriesUseCase()

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getSeries()).thenReturn(expected)

            val actual = getSeriesUseCase()

            assertThat(actual).isEqualTo(expected)
        }
}