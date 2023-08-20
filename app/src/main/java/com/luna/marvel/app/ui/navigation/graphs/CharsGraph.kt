package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class CharsGraph(
    route: String, title: Int? = null, icon: ImageVector? = null, args: List<Args> = emptyList()
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
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object CharacterComics : CharsGraph(
        route = CHARACTER_COMICS,
        title = R.string.top_bar_title_comics,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object CharacterEvents : CharsGraph(
        route = CHARACTER_EVENTS,
        title = R.string.top_bar_title_events,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object CharacterSeries : CharsGraph(
        route = CHARACTER_SERIES,
        title = R.string.top_bar_title_series,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object CharacterStories : CharsGraph(
        route = CHARACTER_STORIES,
        title = R.string.top_bar_title_stories,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "CHARS_GRAPH"
        private const val CHARACTERS = "CHARACTERS"
        private const val CHARACTER_DETAIL = "CHARACTER_DETAIL"
        private const val CHARACTER_COMICS = "CHARACTER_COMICS"
        private const val CHARACTER_EVENTS = "CHARACTER_EVENTS"
        private const val CHARACTER_SERIES = "CHARACTER_SERIES"
        private const val CHARACTER_STORIES = "CHARACTER_STORIES"
    }
}