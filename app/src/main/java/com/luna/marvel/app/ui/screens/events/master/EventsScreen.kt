package com.luna.marvel.app.ui.screens.events.master

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph
import com.luna.marvel.app.ui.navigation.menus.eventsMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.master.MasterScreen

@Composable
fun EventsScreen(
    state: EventsViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {
    MasterScreen(
        destination = EventsGraph.Events,
        menu = eventsMenu,
        items = state.events,
        sendEvent = sendEvent
    )

    state.appError?.let {
        AppDialogScreen(message = it.appError) { sendEvent(MarvelEvent.ResetAppError) }
    }
}