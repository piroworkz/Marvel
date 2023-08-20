package com.luna.marvel.app.ui.screens.events.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
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
            navigateFromMasterEvents(state, navigateUp, viewModel, navigate)
            EventsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsDetail) {
            val viewModel: EventDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventDetailScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(EventsGraph.EventsCharacters) {
            val viewModel: EventCharactersViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventCharactersScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(EventsGraph.EventsComics) {
            val viewModel: EventComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventComicsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(EventsGraph.EventsCreators) {
            val viewModel: EventCreatorsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventCreatorsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(EventsGraph.EventsSeries) {
            val viewModel: EventSeriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventSeriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(EventsGraph.EventsStories) {
            val viewModel: EventStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            EventStoriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

    }

}