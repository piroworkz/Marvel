package com.luna.marvel.app.ui.screens.series.master

import androidx.compose.runtime.Composable
import com.luna.marvel.app.ui.navigation.graphs.SeriesGraph
import com.luna.marvel.app.ui.navigation.menus.seriesMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.master.MasterScreen

@Composable
fun SeriesScreens(
    state: SeriesViewModel.State,
    sendEvent: (MarvelEvent) -> Unit
) {

    MasterScreen(
        destination = SeriesGraph.Series,
        menu = seriesMenu,
        items = state.series,
        sendEvent = sendEvent
    )
    state.appError?.let {
        AppDialogScreen(message = it.appError) { sendEvent(MarvelEvent.ResetAppError) }
    }
}