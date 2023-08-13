package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class MainGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = null,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : MainGraph(
        route = INIT
    )

    data object Menu : MainGraph(
        route = MENU,
        title = com.luna.marvel.R.string.top_bar_title_menu,
        icon = Icons.Rounded.Menu
    )

    data object Characters : MainGraph(
        route = CHARACTERS,
        title = com.luna.marvel.R.string.top_bar_title_characters,
        icon = Icons.Outlined.ArrowBack
    )

    data object Comics : MainGraph(
        route = COMICS,
        title = com.luna.marvel.R.string.top_bar_title_comics,
        icon = Icons.Outlined.ArrowBack
    )

    data object Creators : MainGraph(
        route = CREATORS,
        title = com.luna.marvel.R.string.top_bar_title_creators,
        icon = Icons.Outlined.ArrowBack
    )

    data object Events : MainGraph(
        route = EVENTS,
        title = com.luna.marvel.R.string.top_bar_title_events,
        icon = Icons.Outlined.ArrowBack
    )

    data object Series : MainGraph(
        route = SERIES,
        title = com.luna.marvel.R.string.top_bar_title_series,
        icon = Icons.Outlined.ArrowBack
    )

    data object Stories : MainGraph(
        route = STORIES,
        title = com.luna.marvel.R.string.top_bar_title_stories,
        icon = Icons.Outlined.ArrowBack
    )

    companion object {
        private const val INIT = "INIT"
        private const val MENU = "MENU"
        private const val CHARACTERS = "CHARACTERS"
        private const val COMICS = "COMICS"
        private const val CREATORS = "CREATORS"
        private const val EVENTS = "EVENTS"
        private const val SERIES = "SERIES"
        private const val STORIES = "STORIES"
    }
}