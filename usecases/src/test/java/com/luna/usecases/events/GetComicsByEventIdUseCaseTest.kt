package com.luna.usecases.events

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.EventsRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicsByEventIdUseCaseTest {

    @Mock
    lateinit var repository: EventsRepository

    private val getComicsByEventIdUseCase by lazy { GetComicsByEventIdUseCase(repository) }

    @Test
    fun `on success getComicsByEventIdUseCase() should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComicsByEventId(1)).thenReturn(expected)

            val actual = getComicsByEventIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsByEventIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicsByEventId(1)).thenReturn(expected)

            val actual = getComicsByEventIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}