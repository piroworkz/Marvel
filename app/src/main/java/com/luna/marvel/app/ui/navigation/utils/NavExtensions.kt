package com.luna.marvel.app.ui.navigation.utils

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luna.marvel.app.ui.navigation.graphs.Destination

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

fun <VM> NavGraphBuilder.navComposableVM(
    destination: Destination,
    enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = { null },
    exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = { null },
    content: @Composable (VM) -> Unit,
) = composable(
    route = destination.getRoute(),
    arguments = destination.setArgs(),
    enterTransition = enterTransition,
    exitTransition = exitTransition,
    popEnterTransition = enterTransition,
    popExitTransition = exitTransition
) {
    val viewModel: VM = hiltViewModel()
    content(viewModel)
}

fun NavGraphBuilder.navComposable(
    destination: Destination,
    enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = { null },
    exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = { null },
    content: @Composable (NavBackStackEntry) -> Unit,
) = composable(
    route = destination.getRoute(),
    arguments = destination.setArgs(),
    enterTransition = enterTransition,
    exitTransition = exitTransition,
    popEnterTransition = enterTransition,
    popExitTransition = exitTransition
) {
    content(it)
}

private fun Destination.getRoute(): String {
    return listOf(route)
        .plus(args.map { "{${it.args.first}}" })
        .joinToString("/")
}

private fun Destination.setArgs(): List<NamedNavArgument> =
    args.map { navArgument(name = it.args.first) { type = it.args.second } }