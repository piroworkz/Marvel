package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeStories
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCreatorsByStoryIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getCreatorsByStoryIdUseCase by lazy { GetCreatorsByStoryIdUseCase(repository) }

    @Test
    fun `on success getCreatorsByStoryIdUseCase() should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(repository.getCreatorsByStoryId(1)).thenReturn(expected)

            val actual = getCreatorsByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCreatorsByStoryIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCreatorsByStoryId(1)).thenReturn(expected)

            val actual = getCreatorsByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}