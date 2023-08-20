package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph

val eventsMenu = listOf(
    Events.Detail,
    Events.Characters,
    Events.Comics,
    Events.Creators,
    Events.Series,
    Events.Stories
)

sealed class Events(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object Detail : Events(
        title = R.string.btn_details,
        destination = EventsGraph.EventsDetail
    )

    data object Characters : Events(
        title = R.string.btn_characters,
        destination = EventsGraph.EventsCharacters
    )

    data object Comics : Events(
        title = R.string.btn_comics,
        destination = EventsGraph.EventsComics
    )

    data object Creators : Events(
        title = R.string.btn_creators,
        destination = EventsGraph.EventsCreators
    )

    data object Series : Events(
        title = R.string.btn_series,
        destination = EventsGraph.EventsSeries
    )

    data object Stories : Events(
        title = R.string.btn_stories,
        destination = EventsGraph.EventsStories
    )
}