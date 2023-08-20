package com.luna.marvel.app.ui.screens.characters.master

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.master.MarvelEvent
import com.luna.marvel.app.ui.screens.master.MasterScreen
import com.luna.marvel.app.ui.navigation.menus.characterMenu
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun CharactersScreen(
    state: CharactersViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {
    MasterScreen(
        destination = CharsGraph.Characters,
        menu = characterMenu,
        items = state.characters,
        sendEvent = sendEvent
    )
}

@Preview
@Composable
fun CharactersPreview() {
    MarvelTheme {
        CharactersScreen(
            state = CharactersViewModel.State(),
            sendEvent = {}
        )
    }
}