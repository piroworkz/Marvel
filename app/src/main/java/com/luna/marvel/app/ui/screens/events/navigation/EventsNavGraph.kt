package com.luna.marvel.app.ui.screens.events.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    navigate: (Destination, List<Any>) -> Unit, navigateUp: () -> Unit
) {

    navigation(
        startDestination = EventsGraph.Events.route, route = EventsGraph.Init.route
    ) {

        navComposable(EventsGraph.Events) { viewModel: EventsViewModel ->

            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                isNavigateUp = state.navigateUp,
                destination = state.destination,
                arg = state.id,
                onNavigateUp = navigateUp,
                sendEvent = viewModel::sendEvent,
                navigate = navigate
            )
            EventsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsDetail) { viewModel: EventDetailViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventDetailScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsCharacters) { viewModel: EventCharactersViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventCharactersScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsComics) { viewModel: EventComicsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventComicsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsCreators) { viewModel: EventCreatorsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventCreatorsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsSeries) { viewModel: EventSeriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventSeriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(EventsGraph.EventsStories) { viewModel: EventStoriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            EventStoriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

    }

}