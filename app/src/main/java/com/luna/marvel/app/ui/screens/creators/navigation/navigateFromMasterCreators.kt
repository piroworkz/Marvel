package com.luna.marvel.app.ui.screens.creators.navigation

import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.creators.master.CreatorsViewModel
import com.luna.marvel.app.ui.screens.master.MarvelEvent

fun navigateFromMasterCreators(
    state: CreatorsViewModel.State,
    navigateUp: () -> Unit,
    viewModel: CreatorsViewModel,
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