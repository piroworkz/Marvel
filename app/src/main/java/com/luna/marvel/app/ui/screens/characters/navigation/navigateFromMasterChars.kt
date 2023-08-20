package com.luna.marvel.app.ui.screens.characters.navigation

import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.characters.master.CharactersViewModel
import com.luna.marvel.app.ui.screens.master.MarvelEvent

fun navigateFromMasterChars(
    state: CharactersViewModel.State,
    navigateUp: () -> Unit,
    viewModel: CharactersViewModel,
    navigate: (Destination, List<Any>) -> Unit
) {
    if (state.navigateUp) {
        navigateUp()
        viewModel.sendEvent(MarvelEvent.NavigateUp)
    }
    state.destination?.let {
        navigate(it, listOf(state.characterId ?: ""))
        viewModel.sendEvent(MarvelEvent.NavigateTo(null, null))
    }
}