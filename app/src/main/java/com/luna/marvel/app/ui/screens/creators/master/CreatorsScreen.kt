package com.luna.marvel.app.ui.screens.creators.master

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.menus.creatorsMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.master.MasterScreen

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
    state.appError?.let {
        AppDialogScreen(message = it.appError) { sendEvent(MarvelEvent.ResetAppError) }
    }
}