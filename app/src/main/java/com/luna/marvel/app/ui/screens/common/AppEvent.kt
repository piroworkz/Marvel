package com.luna.marvel.app.ui.screens.common

sealed class AppEvent {
    data object NavigateUp : AppEvent()
    data object ResetAppError : AppEvent()
}