package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination

val characterMenu = listOf(
    Character.Detail,
    Character.Comics,
    Character.Events,
    Character.Series,
    Character.Stories
)

sealed class Character(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object Detail : Character(
        title = R.string.btn_details,
        destination = CharsGraph.CharacterDetail
    )

    data object Comics : Character(
        title = R.string.btn_comics,
        destination = CharsGraph.CharacterComics
    )

    data object Events : Character(
        title = R.string.btn_events,
        destination = CharsGraph.CharacterEvents
    )

    data object Series : Character(
        title = R.string.btn_series,
        destination = CharsGraph.CharacterSeries
    )

    data object Stories : Character(
        title = R.string.btn_stories,
        destination = CharsGraph.CharacterStories
    )
}