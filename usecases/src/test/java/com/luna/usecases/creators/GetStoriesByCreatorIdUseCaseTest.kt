package com.luna.usecases.creators

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.CreatorsRepository
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetStoriesByCreatorIdUseCaseTest {

    @Mock
    lateinit var repository: CreatorsRepository

    private val getStoriesByCreatorIdUseCase by lazy { GetStoriesByCreatorIdUseCase(repository) }

    @Test
    fun `on success getStoriesByCreatorIdUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(repository.getStoriesByCreatorId(1)).thenReturn(expected)

            val actual = getStoriesByCreatorIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getStoriesByCreatorIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getStoriesByCreatorId(1)).thenReturn(expected)

            val actual = getStoriesByCreatorIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}