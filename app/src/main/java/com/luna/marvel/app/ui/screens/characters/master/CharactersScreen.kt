package com.luna.marvel.app.ui.screens.characters.master

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.menus.characterMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.master.MasterScreen
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

    state.appError?.let {
        AppDialogScreen(message = it.appError) { sendEvent(MarvelEvent.ResetAppError) }
    }

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