package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R

sealed class CharsGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = Icons.Outlined.ArrowBack,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : CharsGraph(
        route = INIT
    )

    data object Characters : CharsGraph(
        route = CHARACTERS,
        title = R.string.title_characters
    )

    data object CharacterDetail : CharsGraph(
        route = CHARACTER_DETAIL,
        title = R.string.title_characters,
        args = listOf(Args.ItemId)
    )

    data object CharacterComics : CharsGraph(
        route = CHARACTER_COMICS,
        title = R.string.title_comics,
        args = listOf(Args.ItemId)
    )

    data object CharacterEvents : CharsGraph(
        route = CHARACTER_EVENTS,
        title = R.string.title_events,
        args = listOf(Args.ItemId)
    )

    data object CharacterSeries : CharsGraph(
        route = CHARACTER_SERIES,
        title = R.string.title_series,
        args = listOf(Args.ItemId)
    )

    data object CharacterStories : CharsGraph(
        route = CHARACTER_STORIES,
        title = R.string.title_stories,
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