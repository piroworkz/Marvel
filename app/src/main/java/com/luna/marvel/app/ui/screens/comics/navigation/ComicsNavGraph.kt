package com.luna.marvel.app.ui.screens.comics.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.screens.comics.characters.ComicCharactersScreen
import com.luna.marvel.app.ui.screens.comics.characters.ComicCharactersViewModel
import com.luna.marvel.app.ui.screens.comics.creators.ComicCreatorsScreen
import com.luna.marvel.app.ui.screens.comics.creators.ComicCreatorsViewModel
import com.luna.marvel.app.ui.screens.comics.detail.ComicDetailScreen
import com.luna.marvel.app.ui.screens.comics.detail.ComicDetailViewModel
import com.luna.marvel.app.ui.screens.comics.events.ComicEventsScreen
import com.luna.marvel.app.ui.screens.comics.events.ComicEventsViewModel
import com.luna.marvel.app.ui.screens.comics.master.ComicsScreen
import com.luna.marvel.app.ui.screens.comics.master.ComicsViewModel
import com.luna.marvel.app.ui.screens.comics.stories.ComicStoriesScreen
import com.luna.marvel.app.ui.screens.comics.stories.ComicStoriesViewModel

fun NavGraphBuilder.comicsNavGraph(
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {
    navigation(
        startDestination = ComicsGraph.Comics.route,
        route = ComicsGraph.Init.route
    ) {

        navComposable(ComicsGraph.Comics) {
            val viewModel: ComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            NavigateFromMasterComics(state, navigateUp, viewModel, navigate)
            ComicsScreen(
                state = state,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(ComicsGraph.ComicsDetail) {
            val viewModel: ComicDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            ComicDetailScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(ComicsGraph.ComicsCharacters) {
            val viewModel: ComicCharactersViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            ComicCharactersScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(ComicsGraph.ComicsCreators) {
            val viewModel: ComicCreatorsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            ComicCreatorsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(ComicsGraph.ComicsEvents) {
            val viewModel: ComicEventsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            ComicEventsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(ComicsGraph.ComicsStories) {
            val viewModel: ComicStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            ComicStoriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

    }
}
