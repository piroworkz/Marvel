package com.luna.usecases.characters

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.CharactersRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharacterComicsByIdUseCaseTest {

    @Mock
    lateinit var repository: CharactersRepository

    private val getCharacterComicsByIdUseCase by lazy { GetCharacterComicsByIdUseCase(repository) }

    @Test
    fun `on success getCharacterComicsByIdUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getCharacterComicsById(1)).thenReturn(expected)

            val actual = getCharacterComicsByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharacterComicsByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharacterComicsById(1)).thenReturn(expected)

            val actual = getCharacterComicsByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}