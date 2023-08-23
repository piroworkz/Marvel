package com.luna.marvel.app.ui.screens.stories.creators

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import arrow.core.Either
import com.google.common.truth.Truth
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.navigation.graphs.Args
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeUnknownError
import com.luna.usecases.stories.GetCreatorsByStoryIdUseCase
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class StoryCreatorsViewModelTest {

    @get:Rule
    val coroutineRule = CoroutineTestRule()

    @Mock
    lateinit var savedStateHandle: SavedStateHandle

    @Mock
    lateinit var getCreatorsByStoryIdUseCase: GetCreatorsByStoryIdUseCase

    private val state = StoryCreatorsViewModel.State()
    private val creators = fakeCreators

    @Test
    fun `on ViewModel initialization downloads a list of creators from service`() = runTest {
        whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(1)
        whenever(getCreatorsByStoryIdUseCase(1)).thenReturn(Either.Right(creators))
        val viewModel = StoryCreatorsViewModel(savedStateHandle, getCreatorsByStoryIdUseCase)
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
    fun `on ViewModel initialization downloads an empty list of creators from service and sets AppError on state`() =
        runTest {
            whenever(savedStateHandle.get<Int>(Args.ItemId.args.first)).thenReturn(0)
            val viewModel =
                StoryCreatorsViewModel(savedStateHandle, getCreatorsByStoryIdUseCase)
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
                StoryCreatorsViewModel(savedStateHandle, getCreatorsByStoryIdUseCase)
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
            StoryCreatorsViewModel(savedStateHandle, getCreatorsByStoryIdUseCase)
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