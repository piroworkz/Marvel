package com.luna.marvel.app.ui.screens.characters.navigation

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.common.master.CharacterEvent
import com.luna.marvel.app.ui.screens.common.master.CharactersMasterViewModel

@Composable
fun NavigateFromMasterChars(
    state: CharactersMasterViewModel.State,
    navigateUp: () -> Unit,
    viewModel: CharactersMasterViewModel,
    navigate: (Destination, List<Any>) -> Unit
) {
    if (state.navigateUp) {
        navigateUp()
        viewModel.sendEvent(CharacterEvent.NavigateUp)
    }
    state.destination?.let {
        navigate(it, listOf(state.characterId ?: ""))
        viewModel.sendEvent(CharacterEvent.NavigateTo(null, null))
    }
}