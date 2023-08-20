package com.luna.usecases.series

import arrow.core.Either
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.SeriesRepository
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersBySeriesIdUseCaseTest {

    @Mock
    lateinit var repository: SeriesRepository

    private val getCharactersBySeriesIdUseCase by lazy { GetCharactersBySeriesIdUseCase(repository) }

    @Test
    fun `on success getCharactersBySeriesIdUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(repository.getCharactersBySeriesId(1)).thenReturn(expected)

            val actual = getCharactersBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersBySeriesIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharactersBySeriesId(1)).thenReturn(expected)

            val actual = getCharactersBySeriesIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

}