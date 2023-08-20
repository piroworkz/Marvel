package com.luna.marvel.app.ui.screens.common.master.views

import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class AppMenu(
    val title: Int,
    val destination: Destination? = null
)

val characterMenu = listOf(
    Character.Detail,
    Character.Comics,
    Character.Events,
    Character.Series,
    Character.Stories
)
