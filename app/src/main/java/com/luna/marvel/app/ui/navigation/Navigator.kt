package com.luna.marvel.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.navigation.graphs.SplashGraph
import com.luna.marvel.app.ui.navigation.utils.navigateTo
import com.luna.marvel.app.ui.screens.characters.navigation.charactersNavGraph
import com.luna.marvel.app.ui.screens.comics.navigation.comicsNavGraph
import com.luna.marvel.app.ui.screens.menu.navigation.menuNavGraph
import com.luna.marvel.app.ui.screens.splash.navigation.splashGraph

@Composable
fun Navigator() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashGraph.Init.route
    ) {

        splashGraph {
            navController.navigateTo(MainGraph.Menu) {
                popUpTo(SplashGraph.Splash.route) { inclusive = true }
                launchSingleTop = true
            }
        }

        menuNavGraph(navController::navigateTo)

        charactersNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )

        comicsNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )


    }

}