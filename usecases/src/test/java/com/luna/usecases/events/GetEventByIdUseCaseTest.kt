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
class GetEventByIdUseCaseTest {

    @Mock
    lateinit var repository: EventsRepository

    private val getEventByIdUseCase by lazy { GetEventByIdUseCase(repository) }

    @Test
    fun `on success getEventByIdUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(repository.getEventById(1)).thenReturn(expected)

            val actual = getEventByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getEventById(1)).thenReturn(expected)

            val actual = getEventByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}