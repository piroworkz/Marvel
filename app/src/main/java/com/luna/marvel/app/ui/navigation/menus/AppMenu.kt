package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class AppMenu(
    val title: Int,
    val destination: Destination? = null
)