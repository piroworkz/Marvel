package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class CharsGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = null,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : CharsGraph(INIT)

    data object Characters : CharsGraph(
        route = CHARACTERS,
        title = R.string.top_bar_title_characters,
        icon = Icons.Outlined.ArrowBack
    )

    data object CharacterDetail : CharsGraph(
        route = CHARACTER_DETAIL,
        title = R.string.top_bar_title_characters,
        icon = Icons.Outlined.ArrowBack
    )


    companion object {
        private const val INIT = "CHARS_GRAPH"
        private const val CHARACTERS = "CHARACTERS"
        private const val CHARACTER_DETAIL = "CHARACTER_DETAIL"
    }
}