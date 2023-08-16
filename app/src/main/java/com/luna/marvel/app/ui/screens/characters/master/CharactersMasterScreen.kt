package com.luna.marvel.app.ui.screens.characters.master

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.domain.Character
import com.luna.domain.common.Image
import com.luna.domain.common.Object
import com.luna.marvel.app.ui.application.log
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.screens.characters.master.views.HorizontalPagerView
import com.luna.marvel.app.ui.screens.loading.LoadingView
import com.luna.marvel.app.ui.theme.MarvelTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CharactersMasterScreen(
    state: CharactersMasterViewModel.State
) {

    val pagerState: PagerState = rememberPagerState(pageCount = state.characters::count)

    AppScaffoldView(
        destination = CharsGraph.Characters,
        onNavIconClicked = { /*TODO*/ }
    ) {
        HorizontalPagerView(
            pagerState = pagerState,
            characters = state.characters,
            onClick = {
                it?.route?.log()
            }
        )
        LoadingView(loading = state.characters.isEmpty())
    }

}

@Preview
@Composable
fun CharactersMasterPreview() {
    MarvelTheme {
        CharactersMasterScreen(CharactersMasterViewModel.State(characters = fakeChars))
    }
}

val fakeChars = (0..13).map {
    Character(
        comics = Object(
            available = "intellegebat",
            collectionURI = "adversarium",
            items = listOf(),
            returned = "amet"
        ),
        description = "The typography system in M3 is different to M2. The number of typography parameters is roughly the same, but they have different names and they map differently to M3 components. In Compose, this applies to the M2 Typography class and the M3 Typography class:",
        events = Object(
            available = "cubilia",
            collectionURI = "gloriatur",
            items = listOf(),
            returned = "mazim"
        ),
        id = "discere",
        modified = "affert",
        name = "Shelby Vazquez",
        resourceURI = "homero",
        series = Object(
            available = "omittantur",
            collectionURI = "facilis",
            items = listOf(),
            returned = "antiopam"
        ),
        stories = Object(
            available = "constituto",
            collectionURI = "consectetur",
            items = listOf(),
            returned = "senserit"
        ),
        thumbnail = Image(
            extension = "habitant",
            path = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
        ),
        urls = listOf()
    )
}