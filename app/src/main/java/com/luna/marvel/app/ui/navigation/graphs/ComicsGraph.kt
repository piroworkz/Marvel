@file:Suppress("unused")

package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class ComicsGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = Icons.Outlined.ArrowBack,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : ComicsGraph(
        route = INIT
    )

    data object Comics : ComicsGraph(
        route = COMICS,
        title = R.string.title_comics,
    )

    data object ComicsDetail : ComicsGraph(
        route = COMICS_DETAIL,
        title = R.string.title_comics,
        args = listOf(Args.ItemId)
    )

    data object ComicsCharacters : ComicsGraph(
        route = COMICS_CHARACTERS,
        title = R.string.title_characters,
        args = listOf(Args.ItemId)
    )

    data object ComicsCreators : ComicsGraph(
        route = COMICS_CREATORS,
        title = R.string.title_creators,
        args = listOf(Args.ItemId)
    )

    data object ComicsEvents : ComicsGraph(
        route = COMICS_EVENTS,
        title = R.string.title_events,
        args = listOf(Args.ItemId)
    )

    data object ComicsStories : ComicsGraph(
        route = COMICS_STORIES,
        title = R.string.title_stories,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "COMICS_GRAPH"
        private const val COMICS = "COMICS"
        private const val COMICS_DETAIL = "COMICS_DETAIL"
        private const val COMICS_CHARACTERS = "COMICS_CHARACTERS"
        private const val COMICS_CREATORS = "COMICS_CREATORS"
        private const val COMICS_EVENTS = "COMICS_EVENTS"
        private const val COMICS_STORIES = "COMICS_STORIES"
    }
}