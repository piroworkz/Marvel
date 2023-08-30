package com.luna.usecases.creators

import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.data.repositories.CreatorsRepository
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeError
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class GetComicsByCreatorIdUseCaseTest {

    @Mock
    lateinit var repository: CreatorsRepository

    private val getComicsByCreatorIdUseCase by lazy { GetComicsByCreatorIdUseCase(repository) }

    @Test
    fun `on success getComicsByCreatorIdUseCase() should return a list of creators on the right side of either result`() =
        runTest {
            val expected = Either.Right(fakeComics)
            whenever(repository.getComicsByCreatorId(1)).thenReturn(expected)

            val actual = getComicsByCreatorIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }

    @Test
    fun `on failure getComicsByCreatorIdUseCase() should return an AppError on the left side of either result`() =
        runTest {
            val expected = Either.Left(fakeError)
            whenever(repository.getComicsByCreatorId(1)).thenReturn(expected)

            val actual = getComicsByCreatorIdUseCase(1)

            assertThat(actual).isEqualTo(expected)
        }
}