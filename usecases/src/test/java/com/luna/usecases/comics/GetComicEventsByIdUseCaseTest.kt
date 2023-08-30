package com.luna.usecases.comics

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.ComicsRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicEventsByIdUseCaseTest {

    @Mock
    lateinit var repository: ComicsRepository

    private val getComicEventsByIdUseCase by lazy { GetComicEventsByIdUseCase(repository) }

    @Test
    fun `on success getComicEventsByIdUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(repository.getComicEventsById(1)).thenReturn(expected)

            val actual = getComicEventsByIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicEventsByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicEventsById(1)).thenReturn(expected)

            val actual = getComicEventsByIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}