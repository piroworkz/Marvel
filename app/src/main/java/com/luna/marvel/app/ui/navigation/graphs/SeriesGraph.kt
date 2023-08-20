package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class SeriesGraph(
    route: String,
    title: Int? = null,
    icon: ImageVector? = null,
    args: List<Args> = emptyList()
) : Destination(route, title, icon, args) {

    data object Init : SeriesGraph(
        route = INIT
    )

    data object Series : SeriesGraph(
        route = SERIES,
        title = R.string.title_series,
        icon = Icons.Outlined.ArrowBack
    )

    data object SeriesDetail : SeriesGraph(
        route = SERIES_DETAIL,
        title = R.string.title_series,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object SeriesCharacter : SeriesGraph(
        route = SERIES_CHARACTER,
        title = R.string.title_characters,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object SeriesComics : SeriesGraph(
        route = SERIES_COMICS,
        title = R.string.title_comics,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object SeriesCreators : SeriesGraph(
        route = SERIES_CREATORS,
        title = R.string.title_creators,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object SeriesEvents : SeriesGraph(
        route = SERIES_EVENTS,
        title = R.string.title_events,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    data object SeriesStories : SeriesGraph(
        route = SERIES_STORIES,
        title = R.string.title_stories,
        icon = Icons.Outlined.ArrowBack,
        args = listOf(Args.ItemId)
    )

    companion object {
        private const val INIT = "SERIES_GRAPH"
        private const val SERIES = "SERIES"
        private const val SERIES_DETAIL = "SERIES_DETAIL"
        private const val SERIES_CHARACTER = "SERIES_CHARACTER"
        private const val SERIES_COMICS = "SERIES_COMICS"
        private const val SERIES_CREATORS = "SERIES_CREATORS"
        private const val SERIES_EVENTS = "SERIES_EVENTS"
        private const val SERIES_STORIES = "SERIES_STORIES"
    }
}