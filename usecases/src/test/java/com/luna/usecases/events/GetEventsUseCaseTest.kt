package com.luna.usecases.events

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.EventsRepository
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
class GetEventsUseCaseTest {

    @Mock
    lateinit var repository: EventsRepository

    private val getEventsUseCase by lazy { GetEventsUseCase(repository) }

    @Test
    fun `on success getEventsUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(repository.getEvents()).thenReturn(expected)

            val actual = getEventsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getEvents()).thenReturn(expected)

            val actual = getEventsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }
}