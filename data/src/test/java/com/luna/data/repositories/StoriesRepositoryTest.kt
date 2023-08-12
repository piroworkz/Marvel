package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.StoriesDataSource
import com.luna.testshared.fakeError
import com.luna.testshared.fakeStories
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class StoriesRepositoryTest {

    @Mock
    lateinit var remote: StoriesDataSource

    private lateinit var repository: StoriesRepository

    @Before
    fun setUp() {
        repository = StoriesRepository(remote)
    }

    @Test
    fun `on success getStories should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getStories()).thenReturn(expected)

            val actual = repository.getStories()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStories should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getStories()).thenReturn(expected)

            val actual = repository.getStories()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getStoryById should return a story on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getStoryById(1)).thenReturn(expected)

            val actual = repository.getStoryById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoryById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getStoryById(1)).thenReturn(expected)

            val actual = repository.getStoryById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getCharactersByStoryId should return a list of characters on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getCharactersByStoryId(1)).thenReturn(expected)

            val actual = repository.getCharactersByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersByStoryId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharactersByStoryId(1)).thenReturn(expected)

            val actual = repository.getCharactersByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getComicsByStoryId should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getComicsByStoryId(1)).thenReturn(expected)

            val actual = repository.getComicsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsByStoryId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicsByStoryId(1)).thenReturn(expected)

            val actual = repository.getComicsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getCreatorsByStoryId should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getCreatorsByStoryId(1)).thenReturn(expected)

            val actual = repository.getCreatorsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCreatorsByStoryId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCreatorsByStoryId(1)).thenReturn(expected)

            val actual = repository.getCreatorsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getEventsByStoryId should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getEventsByStoryId(1)).thenReturn(expected)

            val actual = repository.getEventsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsByStoryId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getEventsByStoryId(1)).thenReturn(expected)

            val actual = repository.getEventsByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getSeriesByStoryId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getSeriesByStoryId(1)).thenReturn(expected)

            val actual = repository.getSeriesByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesByStoryId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getSeriesByStoryId(1)).thenReturn(expected)

            val actual = repository.getSeriesByStoryId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}