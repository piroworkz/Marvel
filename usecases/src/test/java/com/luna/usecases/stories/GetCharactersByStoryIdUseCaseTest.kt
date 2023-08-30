package com.luna.usecases.stories

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.StoriesRepository
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCharactersByStoryIdUseCaseTest {

    @Mock
    lateinit var repository: StoriesRepository

    private val getCharactersByStoryIdUseCase by lazy { GetCharactersByStoryIdUseCase(repository) }

    @Test
    fun `on success getCharactersByStoryIdUseCase() should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(repository.getCharactersByStoryId(1)).thenReturn(expected)

            val actual = getCharactersByStoryIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersByStoryIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCharactersByStoryId(1)).thenReturn(expected)

            val actual = getCharactersByStoryIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}