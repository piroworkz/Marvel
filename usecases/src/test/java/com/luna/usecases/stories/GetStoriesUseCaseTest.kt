package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeMarvelItems
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetStoriesUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getStoriesUseCase by lazy { GetStoriesUseCase(repository) }


    @Test
    fun `on success getStoriesUseCase() should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(repository.getStories()).thenReturn(expected)

            val actual = getStoriesUseCase()

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoriesUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getStories()).thenReturn(expected)

            val actual = getStoriesUseCase()

            assertThat(actual).isEqualTo(expected)
        }
}