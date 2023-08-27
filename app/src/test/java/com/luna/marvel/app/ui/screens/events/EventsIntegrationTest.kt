package com.luna.marvel.app.ui.screens.events

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.builders.EventsViewModelsBuilder
import com.luna.marvel.app.ui.screens.events.characters.EventCharactersViewModel
import com.luna.marvel.app.ui.screens.events.comics.EventComicsViewModel
import com.luna.marvel.app.ui.screens.events.creators.EventCreatorsViewModel
import com.luna.marvel.app.ui.screens.events.detail.EventDetailViewModel
import com.luna.marvel.app.ui.screens.events.master.EventsViewModel
import com.luna.marvel.app.ui.screens.events.series.EventSeriesViewModel
import com.luna.marvel.app.ui.screens.events.stories.EventStoriesViewModel
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
class EventsIntegrationTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: EventsViewModelsBuilder

    @Before
    fun setup() {
        builder = EventsViewModelsBuilder()
    }

    @Test
    fun `when getEvents if successful, should return a list of MarvelItems on the right side of either`() =
        runTest {
            val state = EventsViewModel.State()
            val viewModel = builder.eventsViewModel()
            val expected = state.copy(events = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getEventById if successful, should return an event's detail on the right side of either`() =
        runTest {
            val state = EventDetailViewModel.State()
            val viewModel = builder.eventDetailViewModel()
            val expected = state.copy(event = fakeEvents.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getEventById if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventDetailViewModel.State()
            val viewModel = builder.eventDetailViewModel(0)
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
    fun `when getCharactersByEventId if successful should return a list of characters on the right side of either`() =
        runTest {
            val state = EventCharactersViewModel.State()
            val viewModel = builder.eventCharactersViewModel()
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
    fun `when getCharactersByEventId if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventCharactersViewModel.State()
            val viewModel = builder.eventCharactersViewModel(0)
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
    fun `when getComicsByEventId if successful should return a list of comics on the right side of either`() =
        runTest {
            val state = EventComicsViewModel.State()
            val viewModel = builder.eventComicsViewModel()
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
    fun `when getComicsByEventId if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventComicsViewModel.State()
            val viewModel = builder.eventComicsViewModel(0)
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
    fun `when getCreatorsByEventId if successful should return a list of creators on the right side of either`() =
        runTest {
            val state = EventCreatorsViewModel.State()
            val viewModel = builder.eventCreatorsViewModel()
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
    fun `when getCreatorsByEventId if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventCreatorsViewModel.State()
            val viewModel = builder.eventCreatorsViewModel(0)
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
    fun `when getSeriesByEventId if successful should return a list of series on the right side of either`() =
        runTest {
            val state = EventSeriesViewModel.State()
            val viewModel = builder.eventSeriesViewModel()
            val expected = state.copy(series = fakeSeries, loading = true)

            viewModel.state.onEach { }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getSeriesByEventId if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventSeriesViewModel.State()
            val viewModel = builder.eventSeriesViewModel(0)
            val expected = state.copy(appError = fakeNotAvailableError, loading = true)

            viewModel.state.onEach { }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getStoriesByEventId if successful should return a list of stories on the right side of either`() =
        runTest {
            val state = EventStoriesViewModel.State()
            val viewModel = builder.eventStoriesViewModel()
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
    fun `when getStoriesByEventId if response result is empty should return an app error on the left side of either`() =
        runTest {
            val state = EventStoriesViewModel.State()
            val viewModel = builder.eventStoriesViewModel(0)
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