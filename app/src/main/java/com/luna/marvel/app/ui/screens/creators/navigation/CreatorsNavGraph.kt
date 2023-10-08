package com.luna.marvel.app.ui.screens.creators.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.navigation.utils.navigateFromMaster
import com.luna.marvel.app.ui.navigation.utils.navigateUpFromGraph
import com.luna.marvel.app.ui.screens.creators.comics.CreatorComicsScreen
import com.luna.marvel.app.ui.screens.creators.comics.CreatorComicsViewModel
import com.luna.marvel.app.ui.screens.creators.detail.CreatorDetailScreen
import com.luna.marvel.app.ui.screens.creators.detail.CreatorDetailViewModel
import com.luna.marvel.app.ui.screens.creators.events.CreatorEventsScreen
import com.luna.marvel.app.ui.screens.creators.events.CreatorEventsViewModel
import com.luna.marvel.app.ui.screens.creators.master.CreatorsScreen
import com.luna.marvel.app.ui.screens.creators.master.CreatorsViewModel
import com.luna.marvel.app.ui.screens.creators.series.CreatorSeriesScreen
import com.luna.marvel.app.ui.screens.creators.series.CreatorSeriesViewModel
import com.luna.marvel.app.ui.screens.creators.stories.CreatorStoriesScreen
import com.luna.marvel.app.ui.screens.creators.stories.CreatorStoriesViewModel

fun NavGraphBuilder.creatorsNavGraph(
    navigate: (Destination, List<Any>) -> Unit, navigateUp: () -> Unit
) {
    navigation(
        startDestination = CreatorsGraph.Creators.route, route = CreatorsGraph.Init.route
    ) {

        navComposable(CreatorsGraph.Creators) { viewModel: CreatorsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                isNavigateUp = state.navigateUp,
                destination = state.destination,
                arg = state.id,
                onNavigateUp = navigateUp,
                sendEvent = viewModel::sendEvent,
                navigate = navigate
            )
            CreatorsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsDetail) { viewModel: CreatorDetailViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CreatorDetailScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsComics) { viewModel: CreatorComicsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CreatorComicsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsEvents) { viewModel: CreatorEventsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CreatorEventsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsSeries) { viewModel: CreatorSeriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CreatorSeriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsStories) { viewModel: CreatorStoriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CreatorStoriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }
    }
}


