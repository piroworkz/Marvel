package com.luna.marvel.app.ui.screens.characters.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.screens.characters.master.CharactersMasterScreen
import com.luna.marvel.app.ui.screens.characters.master.CharactersMasterViewModel

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

            CharactersMasterScreen(
                state
            )

        }

    }
}