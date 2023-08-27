package com.luna.marvel.app.ui.screens.stories

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.builders.StoriesViewModelsBuilder
import com.luna.marvel.app.ui.screens.stories.characters.StoryCharactersViewModel
import com.luna.marvel.app.ui.screens.stories.comics.StoryComicsViewModel
import com.luna.marvel.app.ui.screens.stories.creators.StoryCreatorsViewModel
import com.luna.marvel.app.ui.screens.stories.detail.StoryDetailViewModel
import com.luna.marvel.app.ui.screens.stories.events.StoryEventsViewModel
import com.luna.marvel.app.ui.screens.stories.master.StoriesViewModel
import com.luna.marvel.app.ui.screens.stories.series.StorySeriesViewModel
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
class StoriesIntegrationTest {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: StoriesViewModelsBuilder

    @Before
    fun setup() {
        builder = StoriesViewModelsBuilder()
    }

    @Test
    fun `when getStories if successful should return a list of marvelItems on right side of either`() =
        runTest {
            val state = StoriesViewModel.State()
            val viewModel = builder.storiesViewModel()
            val expected = state.copy(stories = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getStoryById if successful should return a story's detail on the right side of either`() =
        runTest {
            val state = StoryDetailViewModel.State()
            val viewModel = builder.storyDetailViewModel()
            val expected = state.copy(story = fakeStories.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getStoryById if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StoryDetailViewModel.State()
            val viewModel = builder.storyDetailViewModel(0)
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
    fun `when getCharactersByStoryId if successful should return a list of characters on the right side of either`() =
        runTest {
            val state = StoryCharactersViewModel.State()
            val viewModel = builder.storyCharactersViewModel()
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
    fun `when getCharactersByStoryId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StoryCharactersViewModel.State()
            val viewModel = builder.storyCharactersViewModel(0)
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
    fun `when getComicsByStoryId if successful should return a list of comics on the right side of either`() =
        runTest {
            val state = StoryComicsViewModel.State()
            val viewModel = builder.storyComicsViewModel()
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
    fun `when getComicsByStoryId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StoryComicsViewModel.State()
            val viewModel = builder.storyComicsViewModel(0)
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
    fun `when getCreatorsByStoryId if successful should return a list of creators on the right side of either`() =
        runTest {
            val state = StoryCreatorsViewModel.State()
            val viewModel = builder.storyCreatorsViewModel()
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
    fun `when getCreatorsByStoryId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StoryCreatorsViewModel.State()
            val viewModel = builder.storyCreatorsViewModel(0)
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
    fun `when getEventsByStoryId if successful should return a list of events on the right side of either`() =
        runTest {
            val state = StoryEventsViewModel.State()
            val viewModel = builder.storyEventsViewModel()
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
    fun `when getEventsByStoryId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StoryEventsViewModel.State()
            val viewModel = builder.storyEventsViewModel(0)
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
    fun `when getSeriesByStoryId if successful should return a list of series on the right side of either`() =
        runTest {
            val state = StorySeriesViewModel.State()
            val viewModel = builder.storySeriesViewModel()
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
    fun `when getSeriesByStoryId if response is empty should return an app error on the left side of either`() =
        runTest {
            val state = StorySeriesViewModel.State()
            val viewModel = builder.storySeriesViewModel(0)
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