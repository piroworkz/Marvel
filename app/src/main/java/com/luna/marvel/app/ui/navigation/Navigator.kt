package com.luna.marvel.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.navigation.graphs.SplashGraph
import com.luna.marvel.app.ui.navigation.utils.navigateTo
import com.luna.marvel.app.ui.screens.characters.navigation.charactersNavGraph
import com.luna.marvel.app.ui.screens.comics.navigation.comicsNavGraph
import com.luna.marvel.app.ui.screens.creators.navigation.creatorsNavGraph
import com.luna.marvel.app.ui.screens.events.navigation.eventsNavGraph
import com.luna.marvel.app.ui.screens.menu.navigation.menuNavGraph
import com.luna.marvel.app.ui.screens.series.navigation.seriesNavGraph
import com.luna.marvel.app.ui.screens.splash.navigation.splashGraph
import com.luna.marvel.app.ui.screens.stories.navigation.storiesNavGraph

@Composable
fun Navigator(navController: NavHostController) {
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

        creatorsNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )

        eventsNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )

        seriesNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )

        storiesNavGraph(
            navigate = navController::navigateTo,
            navigateUp = { navController.popBackStack() }
        )
    }

}