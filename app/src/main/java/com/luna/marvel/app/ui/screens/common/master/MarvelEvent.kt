package com.luna.marvel.app.ui.screens.common.master

import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class MarvelEvent {
    data object NavigateUp : MarvelEvent()
    data class NavigateTo(val destination: Destination?, val itemId: Int?) :
        MarvelEvent()
}