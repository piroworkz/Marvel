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
import com.luna.marvel.app.ui.screens.common.master.CharactersMasterScreen
import com.luna.marvel.app.ui.screens.common.master.CharactersMasterViewModel
import com.luna.marvel.app.ui.screens.common.master.views.characterMenu

fun NavGraphBuilder.charactersNavGraph(
    navigate: (Destination, List<Any>) -> Unit,
    navigateUp: () -> Unit
) {
    navigation(
        route = CharsGraph.Init.route,
        startDestination = CharsGraph.Characters.route
    ) {

        navComposable(CharsGraph.Characters) {
            val viewModel: CharactersMasterViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            NavigateFromMasterChars(state, navigateUp, viewModel, navigate)
            CharactersMasterScreen(
                destination = CharsGraph.Characters,
                menu = characterMenu,
                items = state.characters,
                sendEvent = viewModel::sendEvent
            )
        }

        navComposable(CharsGraph.CharacterDetail) {
            val viewModel: CharactersDetailViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            CharactersDetailScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

        navComposable(CharsGraph.CharacterComics) {
            val viewModel: CharactersComicsViewModel = hiltViewModel()
            val state by viewModel.state.collectAsState()
            CharactersComicsScreen(
                state = state,
                navigateUp = navigateUp
            )
        }

    }
}
