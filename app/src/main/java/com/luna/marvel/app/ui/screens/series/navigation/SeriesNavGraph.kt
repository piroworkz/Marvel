package com.luna.marvel.app.ui.screens.series.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    navigate: (Destination, List<Any>) -> Unit, navigateUp: () -> Unit
) {
    navigation(
        startDestination = SeriesGraph.Series.route, route = SeriesGraph.Init.route
    ) {

        navComposable(SeriesGraph.Series) { viewModel: SeriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                isNavigateUp = state.navigateUp,
                destination = state.destination,
                arg = state.id,
                onNavigateUp = navigateUp,
                sendEvent = viewModel::sendEvent,
                navigate = navigate
            )
            SeriesScreens(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(SeriesGraph.SeriesDetail) { viewModel: SeriesDetailViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesDetailScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesCharacter) { viewModel: SeriesCharactersViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesCharactersScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesComics) { viewModel: SeriesComicsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesComicsScreens(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesCreators) { viewModel: SeriesCreatorsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesCreatorsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesEvents) { viewModel: SeriesEventsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesEventsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(SeriesGraph.SeriesStories) { viewModel: SeriesStoriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            SeriesStoriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

    }

}