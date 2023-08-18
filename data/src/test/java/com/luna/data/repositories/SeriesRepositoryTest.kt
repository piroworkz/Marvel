package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.SeriesDataSource
import com.luna.testshared.fakeError
import com.luna.testshared.fakeMarvelItem
import com.luna.testshared.fakeSeries
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class SeriesRepositoryTest {

    @Mock
    lateinit var remote: SeriesDataSource

    private lateinit var repository: SeriesRepository

    @Before
    fun setUp() {
        repository = SeriesRepository(remote)
    }

    @Test
    fun `on success getSeries should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItem)
            whenever(remote.getSeries()).thenReturn(expected)

            val actual = repository.getSeries()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeries should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getSeries()).thenReturn(expected)

            val actual = repository.getSeries()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getSeriesById should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getSeriesById(1)).thenReturn(expected)

            val actual = repository.getSeriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getSeriesById(1)).thenReturn(expected)

            val actual = repository.getSeriesById(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getCharactersBySeriesId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getCharactersBySeriesId(1)).thenReturn(expected)

            val actual = repository.getCharactersBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCharactersBySeriesId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCharactersBySeriesId(1)).thenReturn(expected)

            val actual = repository.getCharactersBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getComicsBySeriesId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getComicsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getComicsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsBySeriesId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getComicsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getCreatorsBySeriesId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getCreatorsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getCreatorsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCreatorsBySeriesId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCreatorsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getCreatorsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getEventsBySeriesId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getEventsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getEventsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsBySeriesId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getEventsBySeriesId(1)).thenReturn(expected)

            val actual = repository.getEventsBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on success getStoriesBySeriesId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(remote.getStoriesBySeriesId(1)).thenReturn(expected)

            val actual = repository.getStoriesBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoriesBySeriesId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getStoriesBySeriesId(1)).thenReturn(expected)

            val actual = repository.getStoriesBySeriesId(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

}