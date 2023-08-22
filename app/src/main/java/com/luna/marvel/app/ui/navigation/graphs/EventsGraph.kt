package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R

sealed class EventsGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = Icons.Outlined.ArrowBack,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : EventsGraph(
        route = INIT
    )

    data object Events : EventsGraph(
        route = EVENTS,
        title = R.string.title_events,
    )

    data object EventsDetail : EventsGraph(
        route = EVENTS_DETAIL,
        title = R.string.title_events,
        args = listOf(Args.ItemId)
    )

    data object EventsCharacters : EventsGraph(
        route = EVENTS_CHARACTERS,
        title = R.string.title_characters,
        args = listOf(Args.ItemId)
    )

    data object EventsComics : EventsGraph(
        route = EVENTS_COMICS,
        title = R.string.title_comics,
        args = listOf(Args.ItemId)
    )

    data object EventsCreators : EventsGraph(
        route = EVENTS_CREATORS,
        title = R.string.title_creators,
        args = listOf(Args.ItemId)
    )

    data object EventsSeries : EventsGraph(
        route = EVENTS_SERIES,
        title = R.string.title_series,
        args = listOf(Args.ItemId)
    )

    data object EventsStories : EventsGraph(
        route = EVENTS_STORIES,
        title = R.string.title_stories,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "EVENTS_GRAPH"
        private const val EVENTS = "EVENTS"
        private const val EVENTS_DETAIL = "EVENTS_DETAIL"
        private const val EVENTS_CHARACTERS = "EVENTS_CHARACTERS"
        private const val EVENTS_COMICS = "EVENTS_COMICS"
        private const val EVENTS_CREATORS = "EVENTS_CREATORS"
        private const val EVENTS_SERIES = "EVENTS_SERIES"
        private const val EVENTS_STORIES = "EVENTS_STORIES"
    }
}