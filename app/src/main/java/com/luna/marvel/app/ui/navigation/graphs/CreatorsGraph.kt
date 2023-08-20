package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class CreatorsGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = Icons.Outlined.ArrowBack,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : CreatorsGraph(
        route = INIT
    )

    data object Creators : CreatorsGraph(
        route = CREATORS,
        title = R.string.title_creators,
    )

    data object CreatorsDetail : CreatorsGraph(
        route = CREATORS_DETAIL,
        title = R.string.title_creators,
        args = listOf(Args.ItemId)
    )

    data object CreatorsComics : CreatorsGraph(
        route = CREATORS_COMICS,
        title = R.string.title_comics,
        args = listOf(Args.ItemId)
    )

    data object CreatorsEvents : CreatorsGraph(
        route = CREATORS_EVENTS,
        title = R.string.title_events,
        args = listOf(Args.ItemId)
    )

    data object CreatorsSeries : CreatorsGraph(
        route = CREATORS_SERIES,
        title = R.string.title_series,
        args = listOf(Args.ItemId)
    )

    data object CreatorsStories : CreatorsGraph(
        route = CREATORS_STORIES,
        title = R.string.title_stories,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "CREATORS_GRAPH"
        private const val CREATORS = "CREATORS"
        private const val CREATORS_DETAIL = "CREATORS_DETAIL"
        private const val CREATORS_COMICS = "CREATORS_COMICS"
        private const val CREATORS_EVENTS = "CREATORS_EVENTS"
        private const val CREATORS_SERIES = "CREATORS_SERIES"
        private const val CREATORS_STORIES = "CREATORS_STORIES"
    }
}