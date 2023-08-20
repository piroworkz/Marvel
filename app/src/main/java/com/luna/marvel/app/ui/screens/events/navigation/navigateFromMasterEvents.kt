package com.luna.marvel.app.ui.screens.events.navigation

import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.events.master.EventsViewModel
import com.luna.marvel.app.ui.screens.master.MarvelEvent

fun navigateFromMasterEvents(
    state: EventsViewModel.State,
    navigateUp: () -> Unit,
    viewModel: EventsViewModel,
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
