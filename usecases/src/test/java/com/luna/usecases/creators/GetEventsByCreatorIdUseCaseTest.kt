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
class GetEventsByCreatorIdUseCaseTest {

    @Mock
    lateinit var repository: CreatorsRepository

    private val getEventsByCreatorIdUseCase by lazy { GetEventsByCreatorIdUseCase(repository) }

    @Test
    fun `on success getEventsByCreatorIdUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(repository.getEventsByCreatorId(1)).thenReturn(expected)

            val actual = getEventsByCreatorIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getEventsByCreatorIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getEventsByCreatorId(1)).thenReturn(expected)

            val actual = getEventsByCreatorIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}