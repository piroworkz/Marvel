package com.luna.marvel.app.ui.screens.stories.navigation

import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.stories.master.StoriesViewModel

fun navigateFromStoriesMaster(
    state: StoriesViewModel.State,
    navigateUp: () -> Unit,
    viewModel: StoriesViewModel,
    navigate: (Destination, List<Any>) -> Unit
) {
    if (state.navigateUp) {
        navigateUp()
        viewModel.sendEvent(MarvelEvent.NavigateUp)
    }
    state.destination?.let {
        navigate(it, listOf(state.id ?: ""))
        viewModel.sendEvent(MarvelEvent.NavigateTo(null, null))
    }
}