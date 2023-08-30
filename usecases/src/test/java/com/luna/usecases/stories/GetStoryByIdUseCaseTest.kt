package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeStories
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetStoryByIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getStoryByIdUseCase by lazy { GetStoryByIdUseCase(repository) }

    @Test
    fun `on success getStoryByIdUseCase() should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(repository.getStoryById(1)).thenReturn(expected)

            val actual = getStoryByIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoryByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getStoryById(1)).thenReturn(expected)

            val actual = getStoryByIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

}