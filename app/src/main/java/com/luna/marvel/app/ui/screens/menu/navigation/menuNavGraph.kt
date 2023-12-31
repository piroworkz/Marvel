package com.luna.marvel.app.ui.screens.menu.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.screens.menu.views.MenuScreen

fun NavGraphBuilder.menuNavGraph(navigate: (Destination) -> Unit) {
    navigation(
        route = MainGraph.Init.route,
        startDestination = MainGraph.Menu.route
    ) {
        navComposable(
            destination = MainGraph.Menu
        ) {
            MenuScreen(navigate)
        }
    }

}