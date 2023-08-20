package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination

val comicsMenu = listOf(
    Comics.ComicsDetail,
    Comics.ComicsCharacters,
    Comics.ComicsCreators,
    Comics.ComicsEvents,
    Comics.ComicsStories
)

sealed class Comics(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object ComicsDetail : Comics(
        title = R.string.btn_details,
        destination = ComicsGraph.ComicsDetail
    )

    data object ComicsCharacters : Comics(
        title = R.string.title_characters,
        destination = ComicsGraph.ComicsCharacters
    )

    data object ComicsCreators : Comics(
        title = R.string.title_creators,
        destination = ComicsGraph.ComicsCreators
    )

    data object ComicsEvents : Comics(
        title = R.string.title_events,
        destination = ComicsGraph.ComicsEvents
    )

    data object ComicsStories : Comics(
        title = R.string.title_stories,
        destination = ComicsGraph.ComicsStories
    )
}