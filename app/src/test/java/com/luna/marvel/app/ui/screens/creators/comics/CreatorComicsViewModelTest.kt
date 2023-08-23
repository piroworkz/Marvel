package com.luna.marvel.app.ui.screens.creators.comics

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
class CreatorComicsViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getCreatorComicsByIdUseCase: GetCharacterComicsByIdUseCase

    private val state = CreatorComicsViewModel.State()
    private val comics = fakeComics


    @Test
    fun `on ViewModel initialization downloads a list of comics from service`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(1)
        whenever(getCreatorComicsByIdUseCase(1)).thenReturn(Either.Right(comics))
        val viewModel = CreatorComicsViewModel(savedStateHandle, getCreatorComicsByIdUseCase)
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
    fun `on ViewModel initialization downloads an empty list of comics from service and sets AppError on state`() =
        runTest {
            whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
            val viewModel =
                CreatorComicsViewModel(savedStateHandle, getCreatorComicsByIdUseCase)
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
    fun `on app event NavigateUp toggles navigateUp`() =
        runTest {
            val viewModel =
                CreatorComicsViewModel(savedStateHandle, getCreatorComicsByIdUseCase)
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
            CreatorComicsViewModel(savedStateHandle, getCreatorComicsByIdUseCase)
        val expected = state.copy(appError = null)

        viewModel.state.onEach { println("<-- $it") }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem().appError).isNotNull()
            Truth.assertThat(awaitItem().loading).isFalse()
            viewModel.sendEvent(AppEvent.ResetAppError)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }


}