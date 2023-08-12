package com.luna.usecases.comics

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.ComicsRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicsUseCaseTest {

    @Mock
    lateinit var repository: ComicsRepository

    private val getComicsUseCase by lazy { GetComicsUseCase(repository) }

    @Test
    fun `on success getComicsUseCase() should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComics()).thenReturn(expected)

            val actual = getComicsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComics()).thenReturn(expected)

            val actual = getComicsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }
}