package com.luna.usecases.creators

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.CreatorsRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeSeries
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetSeriesByCreatorIdUseCaseTest {

    @Mock
    lateinit var repository: CreatorsRepository

    private val getSeriesByCreatorIdUseCase by lazy { GetSeriesByCreatorIdUseCase(repository) }

    @Test
    fun `on success getSeriesByCreatorIdUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeSeries)
            whenever(repository.getSeriesByCreatorId(1)).thenReturn(expected)

            val actual = getSeriesByCreatorIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getSeriesByCreatorIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getSeriesByCreatorId(1)).thenReturn(expected)

            val actual = getSeriesByCreatorIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}