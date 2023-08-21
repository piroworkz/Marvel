package com.luna.marvel.app.ui.screens.series.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.SeriesGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.navigation.utils.navigateFromMaster
import com.luna.marvel.app.ui.navigation.utils.navigateUpFromGraph
import com.luna.marvel.app.ui.screens.series.characters.SeriesCharactersScreen
import com.luna.marvel.app.ui.screens.series.characters.SeriesCharactersViewModel
import com.luna.marvel.app.ui.screens.series.comics.SeriesComicsScreens
import com.luna.marvel.app.ui.screens.series.comics.SeriesComicsViewModel
import com.luna.marvel.app.ui.screens.series.creators.SeriesCreatorsScreen
import com.luna.marvel.app.ui.screens.series.creators.SeriesCreatorsViewModel
import com.luna.marvel.app.ui.screens.series.detail.SeriesDetailScreen
import com.luna.marvel.app.ui.screens.series.detail.SeriesDetailViewModel
import com.luna.marvel.app.ui.screens.series.events.SeriesEventsScreen
import com.luna.marvel.app.ui.screens.series.events.SeriesEventsViewModel
import com.luna.marvel.app.ui.screens.series.master.SeriesScreens
import com.luna.marvel.app.ui.screens.series.master.SeriesViewModel
import com.luna.marvel.app.ui.screens.series.stories.SeriesStoriesScreen
import com.luna.marvel.app.ui.screens.series.stories.SeriesStoriesViewModel

fun NavGraphBuilder.seriesNavGraph(
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {
    navigation(
        startDestination = SeriesGraph.Series.route,
        route = SeriesGraph.Init.route
    ) {

        navComposable(SeriesGraph.Series) {
            val viewModel: SeriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                state.navigateUp,
                state.destination,
                state.id,
                navigateUp,
                viewModel::sendEvent,
                navigate
            )
            SeriesScreens(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(SeriesGraph.SeriesDetail) {
            val viewModel: SeriesDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesDetailScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesCharacter) {
            val viewModel: SeriesCharactersViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesCharactersScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesComics) {
            val viewModel: SeriesComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesComicsScreens(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesCreators) {
            val viewModel: SeriesCreatorsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesCreatorsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesEvents) {
            val viewModel: SeriesEventsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesEventsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesStories) {
            val viewModel: SeriesStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesStoriesScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

    }

}