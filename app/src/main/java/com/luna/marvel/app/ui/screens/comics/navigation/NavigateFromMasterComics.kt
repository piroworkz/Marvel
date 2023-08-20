package com.luna.marvel.app.ui.screens.comics.navigation

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.comics.master.ComicsViewModel
import com.luna.marvel.app.ui.screens.master.MarvelEvent

@Composable
fun NavigateFromMasterComics(
    state: ComicsViewModel.State,
    navigateUp: () -> Unit,
    viewModel: ComicsViewModel,
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