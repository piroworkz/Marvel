package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class SplashGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = null,
    args: List<Args> = emptyList(),
) : Destination(route, title, icon, args) {

    data object Init : SplashGraph(
        route = INIT
    )

    data object Splash : SplashGraph(
        route = SPLASH
    )

    companion object {
        private const val INIT = "SplashGraph"
        private const val SPLASH = "SPLASH"
    }
}
