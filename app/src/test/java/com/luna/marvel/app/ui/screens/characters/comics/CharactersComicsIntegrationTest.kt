package com.luna.marvel.app.ui.screens.characters.comics

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.google.common.truth.Truth
import com.luna.data.repositories.CharactersRepository
import com.luna.data.sources.CharactersDataSource
import com.luna.marvel.app.data.remote.datasources.FakeRemoteCharactersDataSource
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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersComicsIntegrationTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private val comics = fakeComics
    private val state = CharactersComicsViewModel.State()

    @Test
    fun `on view model init calls getComics() and should return a list of comics on the right side of either result`() =
        runTest {
            val viewModel = buildViewModel()
            val expected = state.copy(comics = comics)

            viewModel.state.onEach { println(it) }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem().comics).isNotEmpty()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                cancel()
            }
        }

    @Test
    fun `on view model init calls getComics() and should return an AppError on the left side of either result`() =
        runTest {
            val viewModel = buildViewModel(0)
            val expected = state.copy(appError = fakeUnknownError)

            viewModel.state.onEach { println(it.appError) }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem().comics).isEmpty()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                cancel()
            }
        }

    @Test
    fun `on event NavigateUp should toggle navigateUp state`() = runTest {
        val viewModel = buildViewModel()
        val expected = state.copy(navigateUp = true)

        viewModel.state.onEach { println("Navigate up: " + it.navigateUp) }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            viewModel.sendEvent(AppEvent.NavigateUp)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

    @Test
    fun `on event ResetAppError should reset appError state`() = runTest {
        val viewModel = buildViewModel(0)
        val expected = state.copy(appError = null)

        viewModel.state.onEach { println("AppError: " + it.appError) }.test {
            Truth.assertThat(awaitItem()).isEqualTo(state)
            Truth.assertThat(awaitItem().loading).isTrue()
            Truth.assertThat(awaitItem().appError).isNotNull()
            Truth.assertThat(awaitItem().loading).isFalse()
            viewModel.sendEvent(AppEvent.ResetAppError)
            Truth.assertThat(awaitItem()).isEqualTo(expected)
            cancel()
        }
    }

    private fun buildViewModel(id: Int = 1): CharactersComicsViewModel {
        val remoteDataSource: CharactersDataSource = FakeRemoteCharactersDataSource()
        val repository = CharactersRepository(remoteDataSource)
        val getCharacterComicsByIdUseCase = GetCharacterComicsByIdUseCase(repository)
        val savedStateHandle = SavedStateHandle(mapOf(Args.ItemId.args.first to id))
        return CharactersComicsViewModel(savedStateHandle, getCharacterComicsByIdUseCase)
    }
}