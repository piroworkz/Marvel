package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class StoriesGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = null,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : StoriesGraph(
        route = INIT
    )

    data object Stories : StoriesGraph(
        route = STORIES,
        title = R.string.title_stories,
        icon = Icons.Outlined.ArrowBack
    )

    data object StoriesDetail : StoriesGraph(
        route = STORIES_DETAIL,
        title = R.string.title_stories,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object StoriesCharacters : StoriesGraph(
        route = STORIES_CHARACTERS,
        title = R.string.title_characters,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object StoriesComics : StoriesGraph(
        route = STORIES_COMICS,
        title = R.string.title_comics,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object StoriesCreators : StoriesGraph(
        route = STORIES_CREATORS,
        title = R.string.title_creators,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object StoriesEvents : StoriesGraph(
        route = STORIES_EVENTS,
        title = R.string.title_events,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object StoriesSeries : StoriesGraph(
        route = STORIES_SERIES,
        title = R.string.title_series,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "STORIES_GRAPH"
        private const val STORIES = "STORIES"
        private const val STORIES_DETAIL = "STORIES_DETAIL"
        private const val STORIES_CHARACTERS = "STORIES_CHARACTERS"
        private const val STORIES_COMICS = "STORIES_COMICS"
        private const val STORIES_CREATORS = "STORIES_CREATORS"
        private const val STORIES_EVENTS = "STORIES_EVENTS"
        private const val STORIES_SERIES = "STORIES_SERIES"
    }
}