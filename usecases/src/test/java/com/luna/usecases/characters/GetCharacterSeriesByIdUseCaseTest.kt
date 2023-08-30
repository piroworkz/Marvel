package com.luna.usecases.characters

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.CharactersRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeSeries
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharacterSeriesByIdUseCaseTest {

    @Mock
    lateinit var repository: CharactersRepository

    private val getCharacterSeriesByIdUseCase by lazy {
        GetCharacterSeriesByIdUseCase(repository)
    }

    @Test
    fun `on success getCharacterSeriesByIdUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(repository.getCharacterSeriesById(1)).thenReturn(expected)

            val actual = getCharacterSeriesByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharacterSeriesByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharacterSeriesById(1)).thenReturn(expected)

            val actual = getCharacterSeriesByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}