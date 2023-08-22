package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R

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
        title = R.string.top_bar_title_menu,
        icon = Icons.Rounded.Menu
    )

    companion object {
        private const val INIT = "INIT"
        private const val MENU = "MENU"
    }
}