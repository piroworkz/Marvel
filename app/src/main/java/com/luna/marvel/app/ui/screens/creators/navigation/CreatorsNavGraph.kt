package com.luna.marvel.app.ui.screens.creators.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposable
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
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {
    navigation(
        startDestination = CreatorsGraph.Creators.route,
        route = CreatorsGraph.Init.route
    ) {

        navComposable(CreatorsGraph.Creators) {
            val viewModel: CreatorsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            navigateFromMasterCreators(state, navigateUp, viewModel, navigate)
            CreatorsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CreatorsGraph.CreatorsDetail) {
            val viewModel: CreatorDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CreatorDetailScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CreatorsGraph.CreatorsComics) {
            val viewModel: CreatorComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CreatorComicsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CreatorsGraph.CreatorsEvents) {
            val viewModel: CreatorEventsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CreatorEventsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CreatorsGraph.CreatorsSeries) {
            val viewModel: CreatorSeriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CreatorSeriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CreatorsGraph.CreatorsStories) {
            val viewModel: CreatorStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CreatorStoriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }
    }
}


