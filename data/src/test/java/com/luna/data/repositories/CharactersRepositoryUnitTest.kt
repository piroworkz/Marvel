package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.CharactersDataSource
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.fakeUnknownError
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CharactersRepositoryUnitTest {

    @Mock
    lateinit var remote: CharactersDataSource

    private lateinit var repository: CharactersRepository

    @Before
    fun setUp() {
        repository = CharactersRepository(remote)
    }

    @Test
    fun `getCharacters should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(remote.getCharacters()).thenReturn(expected)

            val actual = repository.getCharacters()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacters should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharacters()).thenReturn(Either.Left(fakeError))

            val actual = repository.getCharacters()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterById should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(remote.getCharacterById(1)).thenReturn(Either.Right(fakeCharacters))

            val actual = repository.getCharacterById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharacterById(1)).thenReturn(Either.Left(fakeError))

            val actual = repository.getCharacterById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterComicsById should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(remote.getCharacterComicsById(1)).thenReturn(expected)

            val actual = repository.getCharacterComicsById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterComicsById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharacterComicsById(1)).thenReturn(Either.Left(fakeError))

            val actual = repository.getCharacterComicsById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterEventsById should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(remote.getCharacterEventsById(1)).thenReturn(expected)

            val actual = repository.getCharacterEventsById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterEventsById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharacterEventsById(1)).thenReturn(Either.Left(fakeError))

            val actual = repository.getCharacterEventsById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterSeriesById should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getCharacterSeriesById(1)).thenReturn(expected)

            val actual = repository.getCharacterSeriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterSeriesById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharacterSeriesById(1)).thenReturn(Either.Left(fakeError))

            val actual = repository.getCharacterSeriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterStoriesById should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getCharacterStoriesById(1)).thenReturn(expected)

            val actual = repository.getCharacterStoriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `getCharacterStoriesById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeUnknownError)
            whenever(remote.getCharacterStoriesById(1)).thenReturn(Either.Left(fakeUnknownError))

            val actual = repository.getCharacterStoriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}