package com.luna.marvel.app.ui.screens.comics.master

import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeUnknownError
import com.luna.usecases.comics.GetComicsUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class ComicsViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Mock
    lateinit var getComicsUseCase: GetComicsUseCase

    private val state = ComicsViewModel.State()
    private val comics = fakeMarvelItems


    @Test
    fun `on init, downloads comics list from service`() = runTest {
        whenever(getComicsUseCase()).thenReturn(Either.Right(comics))
        val viewModel = ComicsViewModel(getComicsUseCase)
        val expected = state.copy(comics = comics, loading = true)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            Truth.assertThat(awaitItem().loading).isFalse()
            cancel()
        }
    }

    @Test
    fun `on init, try to download comics list from service ifEmpty sets AppError`() = runTest {
        val viewModel = ComicsViewModel(getComicsUseCase)
        val expected = state.copy(appError = fakeUnknownError, loading = true)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            Truth.assertThat(awaitItem().loading).isFalse()
            cancel()
        }
    }

    @Test
    fun `on event NavigateTo, sets destination and args id`() = runTest {
        val viewModel = ComicsViewModel(getComicsUseCase)
        val expected = state.copy(destination = CharsGraph.CharacterDetail, id = 1)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            viewModel.sendEvent(MarvelEvent.NavigateTo(CharsGraph.CharacterDetail, 1))
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

    @Test
    fun `on event NavigateUp, toggles navigateUp`() = runTest {
        val viewModel = ComicsViewModel(getComicsUseCase)
        val expected = state.copy(navigateUp = true)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            viewModel.sendEvent(MarvelEvent.NavigateUp)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

    @Test
    fun `on event ResetAppError, resets appError to null`() = runTest {
        val viewModel = ComicsViewModel(getComicsUseCase)
        val expected = state.copy(appError = null)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem().appError).isNotNull()
            Truth.assertThat(awaitItem().loading).isFalse()
            viewModel.sendEvent(MarvelEvent.ResetAppError)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

}