package com.luna.marvel.app.ui.navigation.utils

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.navArgument
import com.luna.marvel.app.ui.navigation.graphs.Destination

fun NavGraphBuilder.navComposable(
    destination: Destination,
    enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = { null },
    exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = { null },
    popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = enterTransition,
    popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = exitTransition,
    content: @Composable (NavBackStackEntry) -> Unit,
) = composable(
    route = destination.getRoute(),
    arguments = destination.setArgs(),
    enterTransition = enterTransition,
    exitTransition = exitTransition,
    popEnterTransition = popEnterTransition,
    popExitTransition = popExitTransition
) { content(it) }

fun NavGraphBuilder.dialogComposable(
    destination: Destination,
    content: @Composable (NavBackStackEntry) -> Unit,
) = dialog(
    route = destination.getRoute(),
    arguments = destination.setArgs(),
    dialogProperties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = true,
        decorFitsSystemWindows = true
    )
) { content(it) }

private fun Destination.getRoute(): String {
    return listOf(route)
        .plus(args.map { "{${it.args.first}}" })
        .joinToString("/")
}

private fun Destination.setArgs(): List<NamedNavArgument> =
    args.map { navArgument(name = it.args.first) { type = it.args.second } }