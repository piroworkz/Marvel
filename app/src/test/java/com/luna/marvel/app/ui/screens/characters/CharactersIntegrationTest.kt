package com.luna.marvel.app.ui.screens.characters

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.builders.CharactersViewModelsBuilder
import com.luna.marvel.app.ui.screens.characters.comics.CharactersComicsViewModel
import com.luna.marvel.app.ui.screens.characters.detail.CharactersDetailViewModel
import com.luna.marvel.app.ui.screens.characters.events.CharacterEventsViewModel
import com.luna.marvel.app.ui.screens.characters.master.CharactersViewModel
import com.luna.marvel.app.ui.screens.characters.series.CharacterSeriesViewModel
import com.luna.marvel.app.ui.screens.characters.stories.CharacterStoriesViewModel
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeNotAvailableError
import com.luna.testshared.fakeSeries
import com.luna.testshared.fakeStories
import com.luna.testshared.fakeUnknownError
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CharactersIntegrationTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: CharactersViewModelsBuilder

    @Before
    fun setup() {
        builder = CharactersViewModelsBuilder()
    }

    @Test
    fun `when getCharacters if successful, should return a list of MarvelItems on the right side of either`() =
        runTest {
            val state = CharactersViewModel.State()
            val viewModel = builder.charactersViewModel()
            val expected = state.copy(characters = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterComicsById if successful, should return comics by character id on right side of either`() =
        runTest {
            val state = CharactersComicsViewModel.State()
            val viewModel = builder.charactersComicsViewModel()
            val expected = state.copy(comics = fakeComics, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterComicsById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CharactersComicsViewModel.State()
            val viewModel = builder.charactersComicsViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterById if successful, should return a character's detail on the right side of either`() =
        runTest {
            val state = CharactersDetailViewModel.State()
            val viewModel = builder.charactersDetailViewModel()
            val expected = state.copy(character = fakeCharacters.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CharactersDetailViewModel.State()
            val viewModel = builder.charactersDetailViewModel(0)
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
    fun `when getCharacterEventsById if successful, should return a list of characters on the right side of either`() =
        runTest {
            val state = CharacterEventsViewModel.State()
            val viewModel = builder.charactersEventsViewModel()
            val expected = state.copy(events = fakeEvents, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterEventsById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CharacterEventsViewModel.State()
            val viewModel = builder.charactersEventsViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterSeriesById if successful, should return a list of Series on the right side of either`() =
        runTest {
            val state = CharacterSeriesViewModel.State()
            val viewModel = builder.charactersSeriesViewModel()
            val expected = state.copy(series = fakeSeries, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterSeriesById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CharacterSeriesViewModel.State()
            val viewModel = builder.charactersSeriesViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterStoriesById if successful, should return a list of Stories on the right side of either`() =
        runTest {
            val state = CharacterStoriesViewModel.State()
            val viewModel = builder.charactersStoriesViewModel()
            val expected = state.copy(stories = fakeStories, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterStoriesById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CharacterStoriesViewModel.State()
            val viewModel = builder.charactersStoriesViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }
}