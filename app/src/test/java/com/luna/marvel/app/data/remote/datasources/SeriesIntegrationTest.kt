package com.luna.marvel.app.data.remote.datasources

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.data.remote.builders.SeriesViewModelsBuilder
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.screens.series.characters.SeriesCharactersViewModel
import com.luna.marvel.app.ui.screens.series.comics.SeriesComicsViewModel
import com.luna.marvel.app.ui.screens.series.creators.SeriesCreatorsViewModel
import com.luna.marvel.app.ui.screens.series.detail.SeriesDetailViewModel
import com.luna.marvel.app.ui.screens.series.events.SeriesEventsViewModel
import com.luna.marvel.app.ui.screens.series.master.SeriesViewModel
import com.luna.marvel.app.ui.screens.series.stories.SeriesStoriesViewModel
import com.luna.testshared.fakeCharacters
import com.luna.testshared.fakeComics
import com.luna.testshared.fakeCreators
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
class SeriesIntegrationTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: SeriesViewModelsBuilder

    @Before
    fun setup() {
        builder = SeriesViewModelsBuilder()
    }

    @Test
    fun `when getSeries if successful should return a list of marvelItems on right side of either`() =
        runTest {
            val state = SeriesViewModel.State()
            val viewModel = builder.buildSeriesViewModel()
            val expected = state.copy(series = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getSeriesById if successful should return a series's detail on the right side of either`() =
        runTest {
            val state = SeriesDetailViewModel.State()
            val viewModel = builder.buildSeriesDetailViewModel()
            val expected = state.copy(series = fakeSeries.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getSeriesById if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesDetailViewModel.State()
            val viewModel = builder.buildSeriesDetailViewModel(0)
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
    fun `when getCharactersBySeriesId if successful should return a list of characters on the right side of either`() =
        runTest {
            val state = SeriesCharactersViewModel.State()
            val viewModel = builder.buildSeriesCharactersViewModel()
            val expected = state.copy(characters = fakeCharacters, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCharactersBySeriesId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesCharactersViewModel.State()
            val viewModel = builder.buildSeriesCharactersViewModel(0)
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
    fun `when getComicsBySeriesId if successful should return a list of comics on the right side of either`() =
        runTest {
            val state = SeriesComicsViewModel.State()
            val viewModel = builder.buildSeriesComicsViewModel()
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
    fun `when getComicsBySeriesId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesComicsViewModel.State()
            val viewModel = builder.buildSeriesComicsViewModel(0)
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
    fun `when getCreatorsBySeriesId if successful should return a list of creators on the right side of either`() =
        runTest {
            val state = SeriesCreatorsViewModel.State()
            val viewModel = builder.buildSeriesCreatorsViewModel()
            val expected = state.copy(creators = fakeCreators, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getCreatorsBySeriesId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesCreatorsViewModel.State()
            val viewModel = builder.buildSeriesCreatorsViewModel(0)
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
    fun `when getEventsBySeriesId if successful should return a list of events on the right side of either`() =
        runTest {
            val state = SeriesEventsViewModel.State()
            val viewModel = builder.buildSeriesEventsViewModel()
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
    fun `when getEventsBySeriesId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesEventsViewModel.State()
            val viewModel = builder.buildSeriesEventsViewModel(0)
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
    fun `when getStoriesBySeriesId if successful should return a list of stories on the right side of either`() =
        runTest {
            val state = SeriesStoriesViewModel.State()
            val viewModel = builder.buildSeriesStoriesViewModel()
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
    fun `when getStoriesBySeriesId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = SeriesStoriesViewModel.State()
            val viewModel = builder.buildSeriesStoriesViewModel(0)
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