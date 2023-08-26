package com.luna.marvel.app.ui.screens.characters.comics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.domain.Comic
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.images
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun CharactersComicsScreen(
    state: CharactersComicsViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = CharsGraph.CharacterComics,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Size.medium)
        ) {
            if (state.comics.isNotEmpty()) {
                state.comics.forEach { comic: Comic ->

                    images(comic.images)
                    title(comic.title)

                    comic.characters.items.ifNotEmpty {
                        categorySubTitle(R.string.title_characters)
                        categoryListView(it)
                    }

                    comic.creators.items.ifNotEmpty {
                        categorySubTitle(R.string.title_creators)
                        categoryListView(it)
                    }

                    comic.events.items.ifNotEmpty {
                        categorySubTitle(R.string.title_events)
                        categoryListView(it)
                    }

                    comic.stories.items.ifNotEmpty {
                        categorySubTitle(R.string.title_stories)
                        categoryListView(it)
                    }

                    whiteDivider()
                }
            }
        }
        LoadingView(loading = state.loading)
        state.appError?.let {
            AppDialogScreen(message = it.appError) {
                sendEvent(AppEvent.NavigateUp)
            }
        }
    }
}


@Preview
@Composable
fun CharactersComicsPreview() {
    MarvelTheme {
        CharactersComicsScreen(
            state = CharactersComicsViewModel.State(),
            sendEvent = { }
        )
    }
}