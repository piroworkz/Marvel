package com.luna.marvel.app.ui.screens.splash.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) { SplashScreen(navigate = navigate) }
    }

}