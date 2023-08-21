package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph

val storiesMenu = listOf(
    Stories.Detail,
    Stories.Characters,
    Stories.Comics,
    Stories.Creators,
    Stories.Events,
    Stories.Series
)

sealed class Stories(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object Detail : Stories(
        title = R.string.btn_details,
        destination = StoriesGraph.StoriesDetail
    )

    data object Characters : Stories(
        title = R.string.btn_characters,
        destination = StoriesGraph.StoriesCharacters
    )

    data object Comics : Stories(
        title = R.string.btn_comics,
        destination = StoriesGraph.StoriesComics
    )

    data object Creators : Stories(
        title = R.string.btn_creators,
        destination = StoriesGraph.StoriesCreators
    )

    data object Events : Stories(
        title = R.string.btn_events,
        destination = StoriesGraph.StoriesEvents
    )

    data object Series : Stories(
        title = R.string.btn_series,
        destination = StoriesGraph.StoriesSeries
    )
}