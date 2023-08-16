package com.luna.marvel.app.ui.screens.utils

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination

sealed class AboutMenu(
    val title: Int,
    val destination: Destination? = null
) {
    data object Detail : AboutMenu(
        title = R.string.btn_details
    )

    data object Comics : AboutMenu(
        title = R.string.btn_comics
    )

    data object Events : AboutMenu(
        title = R.string.btn_events
    )

    data object Series : AboutMenu(
        title = R.string.btn_series
    )

    data object Stories : AboutMenu(
        title = R.string.btn_stories
    )

    data object Characters : AboutMenu(
        title = R.string.btn_characters
    )

    data object Creators : AboutMenu(
        title = R.string.btn_creators
    )


}