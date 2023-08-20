package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeSeries
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetSeriesByStoryIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getSeriesByStoryIdUseCase by lazy { GetSeriesByStoryIdUseCase(repository) }

    @Test
    fun `on success getSeriesByStoryIdUseCase() should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(repository.getSeriesByStoryId(1)).thenReturn(expected)

            val actual = getSeriesByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesByStoryIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getSeriesByStoryId(1)).thenReturn(expected)

            val actual = getSeriesByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}