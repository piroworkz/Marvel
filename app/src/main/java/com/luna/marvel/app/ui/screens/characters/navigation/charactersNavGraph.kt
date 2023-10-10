package com.luna.marvel.app.ui.screens.characters.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposableVM
import com.luna.marvel.app.ui.navigation.utils.navigateFromMaster
import com.luna.marvel.app.ui.navigation.utils.navigateUpFromGraph
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
    navigate: (Destination, List<Any>) -> Unit, navigateUp: () -> Unit
) {
    navigation(
        route = CharsGraph.Init.route, startDestination = CharsGraph.Characters.route
    ) {

        navComposableVM(CharsGraph.Characters) { viewModel: CharactersViewModel ->
            val state by viewModel.state.collectAsState()
            navigateFromMaster(
                state.navigateUp,
                state.destination,
                state.id,
                navigateUp,
                viewModel::sendEvent,
                navigate
            )
            CharactersScreen(state = state, sendEvent = viewModel::sendEvent)
        }

        navComposableVM(CharsGraph.CharacterDetail) { viewModel: CharactersDetailViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CharactersDetailScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposableVM(CharsGraph.CharacterComics) { viewModel: CharactersComicsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CharactersComicsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposableVM(CharsGraph.CharacterEvents) { viewModel: CharacterEventsViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CharacterEventsScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposableVM(CharsGraph.CharacterSeries) { viewModel: CharacterSeriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CharacterSeriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

        navComposableVM(CharsGraph.CharacterStories) { viewModel: CharacterStoriesViewModel ->
            val state by viewModel.state.collectAsState()
            navigateUpFromGraph(state.navigateUp, navigateUp, viewModel::sendEvent)
            CharacterStoriesScreen(
                state = state, sendEvent = viewModel::sendEvent
            )
        }

    }
}