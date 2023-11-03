package com.luna.marvel.app.ui.screens.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.marvel.app.ui.navigation.graphs.SplashGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.screens.splash.view.SplashScreen

fun NavGraphBuilder.splashGraph(navigate: () -> Unit) {

    navigation(
        startDestination = SplashGraph.Splash.route,
        route = SplashGraph.Init.route
    ) {
        navComposable(
            destination = SplashGraph.Splash,
        ) {
            SplashScreen(navigate = navigate)
        }
    }

}