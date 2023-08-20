package com.luna.usecases.comics

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.ComicsRepository
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
class GetComicCharactersByIdUseCaseTest {

    @Mock
    lateinit var repository: ComicsRepository

    private val getComicCharactersByIdUseCase by lazy { GetComicCharactersByIdUseCase(repository) }

    @Test
    fun `on success getComicCharactersByIdUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(repository.getComicCharactersById(1)).thenReturn(expected)

            val actual = getComicCharactersByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicCharactersByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicCharactersById(1)).thenReturn(expected)

            val actual = getComicCharactersByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}