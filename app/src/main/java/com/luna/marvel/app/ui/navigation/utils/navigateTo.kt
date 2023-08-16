package com.luna.marvel.app.ui.navigation.utils

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.SplashGraph

fun NavHostController.navigateTo(
    destination: Destination,
    args: List<Any> = emptyList(),
    navOptionsBuilder: NavOptionsBuilder.() -> Unit = {
        popUpTo(destination.route) {
            inclusive = false
        }
        launchSingleTop = true
    }
) {
    navigate(
        route = destination.createRoute(args),
        builder = { navOptionsBuilder() }
    )
}

private fun Destination.createRoute(args: List<Any>): String = listOf(route)
    .plus(args)
    .joinToString("/")

