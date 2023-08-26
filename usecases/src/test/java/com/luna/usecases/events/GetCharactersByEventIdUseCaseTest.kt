package com.luna.usecases.events

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.EventsRepository
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersByEventIdUseCaseTest {

    @Mock
    lateinit var repository: EventsRepository

    private val getCharactersByEventIdUseCase by lazy { GetCharactersByEventIdUseCase(repository) }

    @Test
    fun `on success getCharactersByEventIdUseCase() should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(repository.getCharactersByEventId(1)).thenReturn(expected)

            val actual = getCharactersByEventIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersByEventIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharactersByEventId(1)).thenReturn(expected)

            val actual = getCharactersByEventIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}