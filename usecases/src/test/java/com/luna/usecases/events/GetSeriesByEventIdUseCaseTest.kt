package com.luna.usecases.events

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.EventsRepository
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
class GetSeriesByEventIdUseCaseTest {

    @Mock
    lateinit var repository: EventsRepository

    private val getSeriesByEventIdUseCase by lazy { GetSeriesByEventIdUseCase(repository) }

    @Test
    fun `on success getSeriesByEventIdUseCase() should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(repository.getSeriesByEventId(1)).thenReturn(expected)

            val actual = getSeriesByEventIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesByEventIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getSeriesByEventId(1)).thenReturn(expected)

            val actual = getSeriesByEventIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}