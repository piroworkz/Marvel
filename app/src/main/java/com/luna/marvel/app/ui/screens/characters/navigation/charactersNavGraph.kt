package com.luna.marvel.app.ui.screens.characters.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.screens.characters.comics.CharactersComicsScreen
import com.luna.marvel.app.ui.screens.characters.comics.CharactersComicsViewModel
import com.luna.marvel.app.ui.screens.characters.detail.CharactersDetailScreen
import com.luna.marvel.app.ui.screens.characters.detail.CharactersDetailViewModel
import com.luna.marvel.app.ui.screens.characters.events.CharacterEventsScreen
import com.luna.marvel.app.ui.screens.characters.events.CharacterEventsViewModel
import com.luna.marvel.app.ui.screens.characters.master.CharactersScreen
import com.luna.marvel.app.ui.screens.characters.master.CharactersViewModel
import com.luna.marvel.app.ui.screens.characters.series.CharacterSeriesScreen
import com.luna.marvel.app.ui.screens.characters.series.CharacterSeriesViewModel
import com.luna.marvel.app.ui.screens.characters.stories.CharacterStoriesScreen
import com.luna.marvel.app.ui.screens.characters.stories.CharacterStoriesViewModel

fun NavGraphBuilder.charactersNavGraph(
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {
    navigation(
        route = CharsGraph.Init.route,
        startDestination = CharsGraph.Characters.route
    ) {

        navComposable(CharsGraph.Characters) {
            val viewModel: CharactersViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            NavigateFromMasterChars(state, navigateUp, viewModel, navigate)
            CharactersScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposable(CharsGraph.CharacterDetail) {
            val viewModel: CharactersDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CharactersDetailScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CharsGraph.CharacterComics) {
            val viewModel: CharactersComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CharactersComicsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CharsGraph.CharacterEvents) {
            val viewModel: CharacterEventsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CharacterEventsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CharsGraph.CharacterSeries) {
            val viewModel: CharacterSeriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CharacterSeriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CharsGraph.CharacterStories) {
            val viewModel: CharacterStoriesViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            if (state.navigateUp) {
                navigateUp()
                viewModel.toggleNavigateUp()
            }
            CharacterStoriesScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

    }
}
