package com.luna.marvel.app.ui.screens.comics.master

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
import com.luna.marvel.app.ui.navigation.menus.comicsMenu
import com.luna.marvel.app.ui.screens.master.MarvelEvent
import com.luna.marvel.app.ui.screens.master.MasterScreen
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun ComicsScreen(
    state: ComicsViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {
    MasterScreen(
        destination = ComicsGraph.Comics,
        menu = comicsMenu,
        items = state.comics,
        sendEvent = sendEvent
    )
}

@Preview
@Composable
fun ComicsPreview() {
    MarvelTheme {
        ComicsScreen(
            state = ComicsViewModel.State(),
            sendEvent = {}
        )
    }
}