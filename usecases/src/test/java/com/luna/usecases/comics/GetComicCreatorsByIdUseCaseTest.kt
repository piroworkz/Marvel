package com.luna.usecases.comics

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.ComicsRepository
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
class GetComicCreatorsByIdUseCaseTest {

    @Mock
    lateinit var repository: ComicsRepository

    private val getComicCreatorsByIdUseCase by lazy {
        GetComicCreatorsByIdUseCase(repository)
    }


    @Test
    fun `on success getComicCreatorsByIdUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeCreators)
            whenever(repository.getComicCreatorsById(1)).thenReturn(expected)

            val actual = getComicCreatorsByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicCreatorsByIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicCreatorsById(1)).thenReturn(expected)

            val actual = getComicCreatorsByIdUseCase(1)

            Truth.assertThat(actual).isEqualTo(expected)
        }
}