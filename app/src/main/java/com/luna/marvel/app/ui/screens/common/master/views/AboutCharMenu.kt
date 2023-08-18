package com.luna.marvel.app.ui.screens.common.master.views

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class AboutCharMenu(
    val title: Int,
    val destination: Destination? = null
) {
    data object Detail : AboutCharMenu(
        title = R.string.btn_details,
        destination = CharsGraph.CharacterDetail
    )

    data object Comics : AboutCharMenu(
        title = R.string.btn_comics
    )

    data object Events : AboutCharMenu(
        title = R.string.btn_events
    )

    data object Series : AboutCharMenu(
        title = R.string.btn_series
    )

    data object Stories : AboutCharMenu(
        title = R.string.btn_stories
    )

    data object Characters : AboutCharMenu(
        title = R.string.btn_characters
    )

    data object Creators : AboutCharMenu(
        title = R.string.btn_creators
    )


}