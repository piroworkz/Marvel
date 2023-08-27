package com.luna.marvel.app.ui.screens.comics

import app.cash.turbine.test
import com.google.common.truth.Truth
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.builders.ComicsViewModelsBuilder
import com.luna.marvel.app.ui.screens.comics.characters.ComicCharactersViewModel
import com.luna.marvel.app.ui.screens.comics.creators.ComicCreatorsViewModel
import com.luna.marvel.app.ui.screens.comics.detail.ComicDetailViewModel
import com.luna.marvel.app.ui.screens.comics.events.ComicEventsViewModel
import com.luna.marvel.app.ui.screens.comics.master.ComicsViewModel
import com.luna.marvel.app.ui.screens.comics.stories.ComicStoriesViewModel
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
import com.luna.testshared.fakeEvents
import com.luna.testshared.fakeMarvelItems
import com.luna.testshared.fakeNotAvailableError
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
class ComicsIntegrationTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: ComicsViewModelsBuilder

    @Before
    fun setup() {
        builder = ComicsViewModelsBuilder()
    }

    @Test
    fun `when getComics if successful, should return a list of MarvelItems on the right side of either`() =
        runTest {
            val state = ComicsViewModel.State()
            val viewModel = builder.comicsViewModel()
            val expected = state.copy(comics = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicCharactersById if successful, should return comics by character id on right side of either`() =
        runTest {
            val state = ComicCharactersViewModel.State()
            val viewModel = builder.comicCharactersViewModel()
            val expected = state.copy(characters = fakeCharacters, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicCharactersById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = ComicCharactersViewModel.State()
            val viewModel = builder.comicCharactersViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicById if successful, should return a character's detail on the right side of either`() =
        runTest {
            val state = ComicDetailViewModel.State()
            val viewModel = builder.comicDetailViewModel()
            val expected = state.copy(comic = fakeComics.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = ComicDetailViewModel.State()
            val viewModel = builder.comicDetailViewModel(0)
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
    fun `when getComicCreatorsById if successful, should return a list of creator on the right side of either`() =
        runTest {
            val state = ComicCreatorsViewModel.State()
            val viewModel = builder.comicCreatorsViewModel()
            val expected = state.copy(creators = fakeCreators, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicCreatorsById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = ComicCreatorsViewModel.State()
            val viewModel = builder.comicCreatorsViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicEventsById if successful, should return a list of Series on the right side of either`() =
        runTest {
            val state = ComicEventsViewModel.State()
            val viewModel = builder.comicEventsViewModel()
            val expected = state.copy(events = fakeEvents, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicEventsById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = ComicEventsViewModel.State()
            val viewModel = builder.comicEventsViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterStoriesById if successful, should return a list of Stories on the right side of either`() =
        runTest {
            val state = ComicStoriesViewModel.State()
            val viewModel = builder.comicStoriesViewModel()
            val expected = state.copy(stories = fakeStories, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharacterStoriesById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = ComicStoriesViewModel.State()
            val viewModel = builder.comicStoriesViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                Truth.assertThat(awaitItem()).isEqualTo(state)
                Truth.assertThat(awaitItem().loading).isTrue()
                Truth.assertThat(awaitItem()).isEqualTo(expected)
                Truth.assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }
}