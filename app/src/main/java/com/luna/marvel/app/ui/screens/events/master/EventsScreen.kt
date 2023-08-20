package com.luna.marvel.app.ui.screens.events.master

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph
import com.luna.marvel.app.ui.navigation.menus.eventsMenu
import com.luna.marvel.app.ui.screens.master.MarvelEvent
import com.luna.marvel.app.ui.screens.master.MasterScreen
import com.luna.marvel.app.ui.theme.MarvelTheme

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
}

@Preview
@Composable
fun EventsPreview() {
    MarvelTheme {
        EventsScreen(
            state = EventsViewModel.State(),
            sendEvent = {}
        )
    }
}