package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCreatorsBySeriesIdUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getCreatorsBySeriesIdUseCase by lazy { GetCreatorsBySeriesIdUseCase(repository) }

    @Test
    fun `on success getCreatorsBySeriesIdUseCase() should return a creators of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(repository.getCreatorsBySeriesId(1)).thenReturn(expected)

            val actual = getCreatorsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCreatorsBySeriesIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCreatorsBySeriesId(1)).thenReturn(expected)

            val actual = getCreatorsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}