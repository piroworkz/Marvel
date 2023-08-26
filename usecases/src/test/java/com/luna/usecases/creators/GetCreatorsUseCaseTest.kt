package com.luna.usecases.creators

import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.data.repositories.CreatorsRepository
import com.luna.testshared.fakeError
import com.luna.testshared.fakeMarvelItems
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetCreatorsUseCaseTest {

    @Mock
    lateinit var repository: CreatorsRepository

    private val getCreatorsUseCase by lazy { GetCreatorsUseCase(repository) }

    @Test
    fun `on success getCreatorsUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeMarvelItems)
            whenever(repository.getCreators()).thenReturn(expected)

            val actual = getCreatorsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getCreatorsUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getCreators()).thenReturn(expected)

            val actual = getCreatorsUseCase()

            Truth.assertThat(actual).isEqualTo(expected)
        }
}