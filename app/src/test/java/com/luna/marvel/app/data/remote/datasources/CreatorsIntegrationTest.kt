package com.luna.marvel.app.data.remote.datasources

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.luna.marvel.app.data.remote.builders.CreatorsViewModelsBuilder
import com.luna.marvel.app.rules.CoroutineTestRule
import com.luna.marvel.app.ui.screens.creators.comics.CreatorComicsViewModel
import com.luna.marvel.app.ui.screens.creators.detail.CreatorDetailViewModel
import com.luna.marvel.app.ui.screens.creators.events.CreatorEventsViewModel
import com.luna.marvel.app.ui.screens.creators.master.CreatorsViewModel
import com.luna.marvel.app.ui.screens.creators.series.CreatorSeriesViewModel
import com.luna.marvel.app.ui.screens.creators.stories.CreatorStoriesViewModel
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
class CreatorsIntegrationTest {

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    private lateinit var builder: CreatorsViewModelsBuilder

    @Before
    fun setup() {
        builder = CreatorsViewModelsBuilder()
    }


    @Test
    fun `when getCreators if successful, should return a list of MarvelItems on the right side of either`() =
        runTest {
            val state = CreatorsViewModel.State()
            val viewModel = builder.creatorsViewModel()
            val expected = state.copy(creators = fakeMarvelItems, loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicById if successful, should return a creator's detail on the right side of either`() =
        runTest {
            val state = CreatorDetailViewModel.State()
            val viewModel = builder.creatorsDetailViewModel()
            val expected = state.copy(creator = fakeCreators.first(), loading = true)

            viewModel.state.onEach { println("<-- $it") }.test {
                assertThat(awaitItem()).isEqualTo(state)
                assertThat(awaitItem().loading).isTrue()
                assertThat(awaitItem()).isEqualTo(expected)
                assertThat(awaitItem().loading).isFalse()
                cancel()
            }
        }

    @Test
    fun `when getComicById if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CreatorDetailViewModel.State()
            val viewModel = builder.creatorsDetailViewModel(0)
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
    fun `when getComicsByCreatorId if successful, should return a list of comics on the right side of either`() =
        runTest {
            val state = CreatorComicsViewModel.State()
            val viewModel = builder.creatorsComicsViewModel()
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
    fun `when getComicsByCreatorId if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CreatorComicsViewModel.State()
            val viewModel = builder.creatorsComicsViewModel(0)
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
    fun `when getEventsByCreatorId if successful, should return a list of events on the right side of either`() =
        runTest {
            val state = CreatorEventsViewModel.State()
            val viewModel = builder.creatorsEventsViewModel()
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
    fun `when getEventsByCreatorId if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CreatorEventsViewModel.State()
            val viewModel = builder.creatorsEventsViewModel(0)
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
    fun `when getStoriesByCreatorId if successful, should return a list of stories on the right side of either`() =
        runTest {
            val state = CreatorStoriesViewModel.State()
            val viewModel = builder.creatorsStoriesViewModel()
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
    fun `when getStoriesByCreatorId if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CreatorStoriesViewModel.State()
            val viewModel = builder.creatorsStoriesViewModel(0)
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
    fun `when getSeriesByCreatorId if successful, should return a list of series on the right side of either`() =
        runTest {
            val state = CreatorSeriesViewModel.State()
            val viewModel = builder.creatorsSeriesViewModel()
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
    fun `when getSeriesByCreatorId if response result is empty, should return app error on left side of either`() =
        runTest {
            val state = CreatorSeriesViewModel.State()
            val viewModel = builder.creatorsSeriesViewModel(0)
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