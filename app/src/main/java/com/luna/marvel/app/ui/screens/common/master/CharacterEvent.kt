package com.luna.marvel.app.ui.screens.common.master

import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class CharacterEvent {
    data object NavigateUp : CharacterEvent()
    data class NavigateTo(val destination: Destination?, val itemId: Int?) :
        CharacterEvent()
}