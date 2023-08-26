package com.luna.usecases.characters

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.CharactersRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeMarvelItems
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersUseCaseTest {

    @Mock
    lateinit var repository: CharactersRepository

    private val getCharactersUseCase by lazy {
        GetCharactersUseCase(repository)
    }


    @Test
    fun `on success getCharactersUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(repository.getCharacters()).thenReturn(expected)

            val actual = getCharactersUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharacters()).thenReturn(expected)

            val actual = getCharactersUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }
}