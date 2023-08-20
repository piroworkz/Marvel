package com.luna.marvel.app.ui.screens.creators.master

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.menus.creatorsMenu
import com.luna.marvel.app.ui.screens.master.MarvelEvent
import com.luna.marvel.app.ui.screens.master.MasterScreen
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun CreatorsScreen(
    state: CreatorsViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {
    MasterScreen(
        destination = CreatorsGraph.Creators,
        menu = creatorsMenu,
        items = state.creators,
        sendEvent = sendEvent
    )
}

@Preview
@Composable
fun CreatorsPreview() {
    MarvelTheme {
        CreatorsScreen(
            state = CreatorsViewModel.State(),
            sendEvent = {}
        )
    }
}