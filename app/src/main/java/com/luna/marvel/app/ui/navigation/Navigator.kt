package com.luna.marvel.app.ui.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.navigation.graphs.SplashGraph
import com.luna.marvel.app.ui.navigation.utils.navComposable
import com.luna.marvel.app.ui.navigation.utils.navigateTo
import com.luna.marvel.app.ui.screens.menu.MenuScreen
import com.luna.marvel.app.ui.screens.splash.navigation.splashGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigator() {

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { /*TODO*/ },
        drawerState = drawerState
    ) {
        NavHost(
            navController = navController,
            startDestination = SplashGraph.Init.route
        ) {

            splashGraph {
                navController.navigateTo(MainGraph.Menu) {
                    popUpTo(SplashGraph.Splash.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }

            navComposable(
                destination = MainGraph.Menu,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None }
            ) {
                MenuScreen()
            }
        }
    }
}