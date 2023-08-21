package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.ComicsDataSource
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeError
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItem
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
class ComicsRepositoryTest {

    @Mock
    lateinit var remote: ComicsDataSource

    private lateinit var repository: ComicsRepository

    @Before
    fun setUp() {
        repository = ComicsRepository(remote)
    }

    @Test
    fun `getComics should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItem)
            whenever(remote.getComics()).thenReturn(expected)

            val result = repository.getComics()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComics should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComics()).thenReturn(expected)

            val result = repository.getComics()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicById should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(remote.getComicById(1)).thenReturn(expected)

            val result = repository.getComicById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicById should return an AppError on the left side of either result`() = runTest {
        val expected = Either.Left(fakeError)
        whenever(remote.getComicById(1)).thenReturn(expected)

        val result = repository.getComicById(1)

        Truth.assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `getComicCharactersById should return a list of character on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCharacters)
            whenever(remote.getComicCharactersById(1)).thenReturn(expected)

            val result = repository.getComicCharactersById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicCharactersById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicCharactersById(1)).thenReturn(expected)

            val result = repository.getComicCharactersById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicCreatorsById should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getComicCreatorsById(1)).thenReturn(expected)

            val result = repository.getComicCreatorsById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicCreatorsById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicCreatorsById(1)).thenReturn(expected)

            val result = repository.getComicCreatorsById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicEventsById should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeEvents)
            whenever(remote.getComicEventsById(1)).thenReturn(expected)

            val result = repository.getComicEventsById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicEventsById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicEventsById(1)).thenReturn(expected)

            val result = repository.getComicEventsById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicStoriesById should return a list of storiess on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeStories)
            whenever(remote.getComicStoriesById(1)).thenReturn(expected)

            val result = repository.getComicStoriesById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicStoriesById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicStoriesById(1)).thenReturn(expected)

            val result = repository.getComicStoriesById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

}