package com.luna.data.repositories

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.sources.CreatorsDataSource
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class CreatorsRepositoryTest {

    @Mock
    lateinit var remote: CreatorsDataSource

    private lateinit var repository: CreatorsRepository

    @Before
    fun setUp() {
        repository = CreatorsRepository(remote)
    }

    @Test
    fun `getCreators should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getCreators()).thenReturn(expected)

            val result = repository.getCreators()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCreators should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCreators()).thenReturn(expected)

            val result = repository.getCreators()

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCreatorById should return a creator on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getCreatorById(1)).thenReturn(expected)

            val result = repository.getCreatorById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getCreatorById should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getCreatorById(1)).thenReturn(expected)

            val result = repository.getCreatorById(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicsByCreatorId should return a list of comics on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getComicsByCreatorId(1)).thenReturn(expected)

            val result = repository.getComicsByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getComicsByCreatorId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getComicsByCreatorId(1)).thenReturn(expected)

            val result = repository.getComicsByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getEventsByCreatorId should return a list of events on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getEventsByCreatorId(1)).thenReturn(expected)

            val result = repository.getEventsByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getEventsByCreatorId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getEventsByCreatorId(1)).thenReturn(expected)

            val result = repository.getEventsByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getSeriesByCreatorId should return a list of series on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getSeriesByCreatorId(1)).thenReturn(expected)

            val result = repository.getSeriesByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getSeriesByCreatorId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getSeriesByCreatorId(1)).thenReturn(expected)

            val result = repository.getSeriesByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getStoriesByCreatorId should return a list of stories on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(remote.getStoriesByCreatorId(1)).thenReturn(expected)

            val result = repository.getStoriesByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }

    @Test
    fun `getStoriesByCreatorId should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(remote.getStoriesByCreatorId(1)).thenReturn(expected)

            val result = repository.getStoriesByCreatorId(1)

            Truth.assertThat(result).isEqualTo(expected)
        }
}
