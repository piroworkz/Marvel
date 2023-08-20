package com.luna.marvel.app.ui.screens.common.master.views

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination


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
        title = R.string.btn_events
    )

    data object Series : Character(
        title = R.string.btn_series
    )

    data object Stories : Character(
        title = R.string.btn_stories
    )

    data object Characters : Character(
        title = R.string.btn_characters
    )

    data object Creators : Character(
        title = R.string.btn_creators
    )
}