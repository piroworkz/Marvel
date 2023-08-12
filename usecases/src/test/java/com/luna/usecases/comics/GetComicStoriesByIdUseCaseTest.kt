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
class GetComicStoriesByIdUseCaseTest {

    @Mock
    lateinit var repository: ComicsRepository

    private val getComicStoriesByIdUseCase by lazy { GetComicStoriesByIdUseCase(repository) }

    @Test
    fun `on success getComicStoriesByIdUseCase() should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComicStoriesById(1)).thenReturn(expected)

            val actual = getComicStoriesByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicStoriesByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicStoriesById(1)).thenReturn(expected)

            val actual = getComicStoriesByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}