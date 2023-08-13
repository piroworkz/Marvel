package com.luna.marvel.app.ui.navigation.utils

import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import com.luna.marvel.app.ui.navigation.graphs.Destination

fun NavHostController.navigateTo(
    destination: Destination,
    args: List<Any> = emptyList(),
    navOptionsBuilder: NavOptionsBuilder.() -> Unit = {}
) {
    navigate(
        route = destination.createRoute(args),
        builder = { navOptionsBuilder() }
    )
}

private fun Destination.createRoute(args: List<Any>): String = listOf(route)
    .plus(args)
    .joinToString("/")

