package com.luna.marvel.app.ui.navigation.utils

import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.common.MarvelEvent

fun navigateFromMaster(
    isNavigateUp: Boolean,
    destination: Destination?,
    arg: Int?,
    onNavigateUp: () -> Unit,
    sendEvent: (MarvelEvent) -> Unit,
    navigate: (Destination, List<Any>) -> Unit
) {
    if (isNavigateUp) {
        onNavigateUp()
        sendEvent(MarvelEvent.NavigateUp)
    }
    destination?.let {
        navigate(it, listOf(arg ?: ""))
        sendEvent(MarvelEvent.NavigateTo(null, null))
    }
}