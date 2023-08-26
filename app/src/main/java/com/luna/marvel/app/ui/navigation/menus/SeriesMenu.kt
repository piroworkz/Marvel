package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.SeriesGraph

val seriesMenu = listOf(
    Series.Detail,
    Series.Characters,
    Series.Comics,
    Series.Creators,
    Series.Events,
    Series.Stories
)

sealed class Series(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object Detail : Series(
        title = R.string.btn_details,
        destination = SeriesGraph.SeriesDetail
    )

    data object Characters : Series(
        title = R.string.btn_characters,
        destination = SeriesGraph.SeriesCharacter
    )

    data object Comics : Series(
        title = R.string.btn_comics,
        destination = SeriesGraph.SeriesComics
    )

    data object Creators : Series(
        title = R.string.btn_creators,
        destination = SeriesGraph.SeriesCreators
    )

    data object Events : Series(
        title = R.string.btn_events,
        destination = SeriesGraph.SeriesEvents
    )

    data object Stories : Series(
        title = R.string.btn_stories,
        destination = SeriesGraph.SeriesStories
    )
}