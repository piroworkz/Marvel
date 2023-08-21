package com.luna.marvel.app.ui.screens.stories.master

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph
import com.luna.marvel.app.ui.navigation.menus.storiesMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.master.MasterScreen

@Composable
fun StoriesScreen(
    state: StoriesViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {
    MasterScreen(
        destination = StoriesGraph.Stories,
        menu = storiesMenu,
        items = state.stories,
        sendEvent = sendEvent
    )

    state.appError?.let {
        AppDialogScreen(message = it.appError) { sendEvent(MarvelEvent.ResetAppError) }
    }
}