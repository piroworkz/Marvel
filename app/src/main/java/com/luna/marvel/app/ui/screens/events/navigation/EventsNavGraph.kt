package com.luna.marvel.app.ui.screens.events.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.navigation.utils.navigateFromMaster
import com.luna.marvel.app.ui.navigation.utils.navigateUpFromGraph
import com.luna.marvel.app.ui.screens.events.characters.EventCharactersScreen
import com.luna.marvel.app.ui.screens.events.characters.EventCharactersViewModel
import com.luna.marvel.app.ui.screens.events.comics.EventComicsScreen
import com.luna.marvel.app.ui.screens.events.comics.EventComicsViewModel
import com.luna.marvel.app.ui.screens.events.creators.EventCreatorsScreen
import com.luna.marvel.app.ui.screens.events.creators.EventCreatorsViewModel
import com.luna.marvel.app.ui.screens.events.detail.EventDetailScreen
import com.luna.marvel.app.ui.screens.events.detail.EventDetailViewModel
import com.luna.marvel.app.ui.screens.events.master.EventsScreen
import com.luna.marvel.app.ui.screens.events.master.EventsViewModel
import com.luna.marvel.app.ui.screens.events.series.EventSeriesScreen
import com.luna.marvel.app.ui.screens.events.series.EventSeriesViewModel
import com.luna.marvel.app.ui.screens.events.stories.EventStoriesScreen
import com.luna.marvel.app.ui.screens.events.stories.EventStoriesViewModel

fun NavGraphBuilder.eventsNavGraph(
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {

    navigation(
        startDestination = EventsGraph.Events.route,
        route = EventsGraph.Init.route
    ) {

        navComposable(EventsGraph.Events) {
            val viewModel: EventsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                state.navigateUp,
                state.destination,
                state.id,
                navigateUp,
                viewModel::sendEvent,
                navigate
            )
            EventsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsDetail) {
            val viewModel: EventDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventDetailScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsCharacters) {
            val viewModel: EventCharactersViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventCharactersScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsComics) {
            val viewModel: EventComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventComicsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsCreators) {
            val viewModel: EventCreatorsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventCreatorsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsSeries) {
            val viewModel: EventSeriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventSeriesScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsStories) {
            val viewModel: EventStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventStoriesScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

    }

}