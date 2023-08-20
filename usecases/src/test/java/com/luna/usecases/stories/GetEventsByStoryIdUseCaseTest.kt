package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetEventsByStoryIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getEventsByStoryIdUseCase by lazy { GetEventsByStoryIdUseCase(repository) }

    @Test
    fun `on success getEventsByStoryIdUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(repository.getEventsByStoryId(1)).thenReturn(expected)

            val actual = getEventsByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsByStoryIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getEventsByStoryId(1)).thenReturn(expected)

            val actual = getEventsByStoryIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}