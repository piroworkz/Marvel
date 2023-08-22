package com.luna.marvel.app.ui.screens.characters.comics

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeUnknownError
import com.luna.usecases.characters.GetCharacterComicsByIdUseCase
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
class CharactersComicsViewModelTest {


    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getCharacterComicsByIdUseCase: GetCharacterComicsByIdUseCase

    private val state = CharactersComicsViewModel.State()
    private val comics = fakeComics

    @Test
    fun `on ViewModel initialization downloads a list of comics from service`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(1)
        whenever(getCharacterComicsByIdUseCase(1)).thenReturn(Either.Right(comics))
        val viewModel = CharactersComicsViewModel(savedStateHandle, getCharacterComicsByIdUseCase)
        val expected = state.copy(comics = comics)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            awaitItem()
            awaitItem()
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

    @Test
    fun `on ViewModel initialization downloads an empty list of comics from service and sets AppError on state`() =
        runTest {
            whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
            val viewModel =
                CharactersComicsViewModel(savedStateHandle, getCharacterComicsByIdUseCase)
            val expected = state.copy(appError = fakeUnknownError)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                awaitItem()
                awaitItem()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                cancel()
            }
        }


    @Test
    fun `on app event NavigateUp toggles navigateUp`() =
        runTest {
            val viewModel =
                CharactersComicsViewModel(savedStateHandle, getCharacterComicsByIdUseCase)
            val expected = state.copy(navigateUp = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                viewModel.sendEvent(AppEvent.NavigateUp)
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                cancel()
            }
        }

    @Test
    fun `on app event ResetAppError resets appError`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
        val viewModel =
            CharactersComicsViewModel(savedStateHandle, getCharacterComicsByIdUseCase)
        val expected = state.copy(appError = null)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            awaitItem()
            awaitItem()
            awaitItem()
            viewModel.sendEvent(AppEvent.ResetAppError)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

}