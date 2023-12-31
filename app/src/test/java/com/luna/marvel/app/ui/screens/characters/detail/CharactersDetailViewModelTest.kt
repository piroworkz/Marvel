package com.luna.marvel.app.ui.screens.characters.detail

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeUnknownError
import com.luna.usecases.characters.GetCharacterByIdUseCase
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
class CharactersDetailViewModelTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getCharacterByIdUseCase: GetCharacterByIdUseCase

    private val state = CharactersDetailViewModel.State()
    private val character = fakeCharacters.first()

    @Test
    fun `on ViewModel initialization downloads a character detail from service`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(1)
        whenever(getCharacterByIdUseCase(1)).thenReturn(Either.Right(fakeCharacters))
        val viewModel = CharactersDetailViewModel(savedStateHandle, getCharacterByIdUseCase)
        val expected = state.copy(character = character, loading = true)

        viewModel.state.onEach { println("<-- $it") }.test {
            assertThat(awaitItem()).isEqualTo(state)
            assertThat(awaitItem().loading).isTrue()
            assertThat(awaitItem()).isEqualTo(expected)
            assertThat(awaitItem().loading).isFalse()
            cancel()
        }
    }

    @Test
    fun `on ViewModel initialization downloads an empty list of characters from service and sets AppError on state`() =
        runTest {
            whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
            val viewModel =
                CharactersDetailViewModel(savedStateHandle, getCharacterByIdUseCase)
            val expected = state.copy(appError = fakeUnknownError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }


    @Test
    fun `on app event NavigateUp toggles navigateUp`() =
        runTest {
            val viewModel =
                CharactersDetailViewModel(savedStateHandle, getCharacterByIdUseCase)
            val expected = state.copy(navigateUp = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                viewModel.sendEvent(AppEvent.NavigateUp)
                assertThat(awaitItem()).isEqualTo(expected)
                cancel()
            }
        }

    @Test
    fun `on app event ResetAppError resets appError`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
        val viewModel =
            CharactersDetailViewModel(savedStateHandle, getCharacterByIdUseCase)
        val expected = state.copy(appError = null)

        viewModel.state.onEach { println("<-- $it") }.test {
            assertThat(awaitItem()).isEqualTo(state)
            assertThat(awaitItem().loading).isTrue()
            assertThat(awaitItem().appError).isNotNull()
            assertThat(awaitItem().loading).isFalse()
            viewModel.sendEvent(AppEvent.ResetAppError)
            assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }
}