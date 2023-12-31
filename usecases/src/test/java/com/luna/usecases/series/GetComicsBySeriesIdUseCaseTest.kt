package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicsBySeriesIdUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getComicsBySeriesIdUseCase by lazy { GetComicsBySeriesIdUseCase(repository) }

    @Test
    fun `on success getComicsBySeriesIdUseCase() should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComicsBySeriesId(1)).thenReturn(expected)

            val actual = getComicsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsBySeriesIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicsBySeriesId(1)).thenReturn(expected)

            val actual = getComicsBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}