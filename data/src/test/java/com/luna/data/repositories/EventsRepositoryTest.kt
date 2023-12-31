package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.EventsDataSource
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class EventsRepositoryTest {

    @Mock
    lateinit var remote: EventsDataSource

    private lateinit var repository: EventsRepository

    @Before
    fun setUp() {
        repository = EventsRepository(remote)
    }

    @Test
    fun `getEvents should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(remote.getEvents()).thenReturn(expected)

            val result = repository.getEvents()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getEvents should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getEvents()).thenReturn(expected)

            val result = repository.getEvents()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getEventById should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(remote.getEventById(1)).thenReturn(expected)

            val result = repository.getEventById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getEventById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getEventById(1)).thenReturn(expected)

            val result = repository.getEventById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCharactersByEventId should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(remote.getCharactersByEventId(1)).thenReturn(expected)

            val result = repository.getCharactersByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCharactersByEventId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharactersByEventId(1)).thenReturn(expected)

            val result = repository.getCharactersByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicsByEventId should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(remote.getComicsByEventId(1)).thenReturn(expected)

            val result = repository.getComicsByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicsByEventId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicsByEventId(1)).thenReturn(expected)

            val result = repository.getComicsByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCreatorsByEventId should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getCreatorsByEventId(1)).thenReturn(expected)

            val result = repository.getCreatorsByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCreatorsByEventId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCreatorsByEventId(1)).thenReturn(expected)

            val result = repository.getCreatorsByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getSeriesByEventId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getSeriesByEventId(1)).thenReturn(expected)

            val result = repository.getSeriesByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getSeriesByEventId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getSeriesByEventId(1)).thenReturn(expected)

            val result = repository.getSeriesByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getStoriesByEventId should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getStoriesByEventId(1)).thenReturn(expected)

            val result = repository.getStoriesByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getStoriesByEventId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getStoriesByEventId(1)).thenReturn(expected)

            val result = repository.getStoriesByEventId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }
}
