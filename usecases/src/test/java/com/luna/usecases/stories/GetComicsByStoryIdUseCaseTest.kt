package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicsByStoryIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getComicsByStoryIdUseCase by lazy { GetComicsByStoryIdUseCase(repository) }

    @Test
    fun `on success getComicsByStoryIdUseCase() should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComicsByStoryId(1)).thenReturn(expected)

            val actual = getComicsByStoryIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsByStoryIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicsByStoryId(1)).thenReturn(expected)

            val actual = getComicsByStoryIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}