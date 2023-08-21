package com.luna.marvel.app.ui.navigation.utils

import com.luna.marvel.app.ui.screens.common.AppEvent

fun navigateUpFromGraph(
    state: Boolean,
    navigateUp: () -> Unit,
    sendEvent: (AppEvent) -> Unit
) {
    if (state) {
        navigateUp()
        sendEvent(AppEvent.ResetAppError)
        sendEvent(AppEvent.NavigateUp)
    }
}