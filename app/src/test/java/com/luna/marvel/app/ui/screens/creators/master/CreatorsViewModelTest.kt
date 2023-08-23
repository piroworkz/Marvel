package com.luna.marvel.app.ui.screens.creators.master

import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeUnknownError
import com.luna.usecases.creators.GetCreatorsUseCase
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
class CreatorsViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var getCreatorsUseCase: GetCreatorsUseCase

    private val state = CreatorsViewModel.State()
    private val creators = fakeMarvelItems


    @Test
    fun `on init, downloads creators list from service`() = runTest {
        whenever(getCreatorsUseCase()).thenReturn(Either.Right(creators))
        val viewModel = CreatorsViewModel(getCreatorsUseCase)
        val expected = state.copy(creators = creators, loading = true)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            Truth.assertThat(awaitItem().loading).isFalse()
            cancel()
        }
    }

    @Test
    fun `on init, try to download creators list from service ifEmpty sets AppError`() = runTest {
        val viewModel = CreatorsViewModel(getCreatorsUseCase)
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
        val viewModel = CreatorsViewModel(getCreatorsUseCase)
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
        val viewModel = CreatorsViewModel(getCreatorsUseCase)
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
        val viewModel = CreatorsViewModel(getCreatorsUseCase)
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