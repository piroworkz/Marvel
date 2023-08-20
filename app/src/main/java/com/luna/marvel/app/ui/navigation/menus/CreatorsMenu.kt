package com.luna.marvel.app.ui.navigation.menus

import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination

val creatorsMenu = listOf(
    Creators.Detail,
    Creators.Comics,
    Creators.Events,
    Creators.Series,
    Creators.Stories
)

sealed class Creators(
    title: Int,
    destination: Destination? = null
) : AppMenu(title, destination) {

    data object Detail : Creators(
        title = R.string.btn_details,
        destination = CreatorsGraph.CreatorsDetail
    )

    data object Comics : Creators(
        title = R.string.btn_comics,
        destination = CreatorsGraph.CreatorsComics
    )

    data object Events : Creators(
        title = R.string.btn_events,
        destination = CreatorsGraph.CreatorsEvents
    )

    data object Series : Creators(
        title = R.string.btn_series,
        destination = CreatorsGraph.CreatorsSeries
    )

    data object Stories : Creators(
        title = R.string.btn_stories,
        destination = CreatorsGraph.CreatorsStories
    )

}