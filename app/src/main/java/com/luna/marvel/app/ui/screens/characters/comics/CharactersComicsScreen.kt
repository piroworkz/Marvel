package com.luna.marvel.app.ui.screens.characters.comics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.domain.Comic
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.images
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.background

@Composable
fun CharactersComicsScreen(
    state: CharactersComicsViewModel.State,
    navigateUp: () -> Unit
) {

    AppScaffoldView(
        destination = CharsGraph.CharacterComics,
        onNavIconClicked = navigateUp
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

                    if (comic.characters.items.isNotEmpty()) {
                        categorySubTitle("Characters")
                        categoryListView(comic.characters.items)
                    }

                    if (comic.creators.items.isNotEmpty()) {
                        categorySubTitle("Creators")
                        categoryListView(comic.creators.items)
                    }

                    if (comic.events.items.isNotEmpty()) {
                        categorySubTitle("Events")
                        categoryListView(comic.events.items)
                    }

                    if (comic.stories.items.isNotEmpty()) {
                        categorySubTitle("Stories")
                        categoryListView(comic.stories.items)
                    }

                    item(span = { GridItemSpan(2) }) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = Dimens.Size.medium),
                            thickness = Dimens.Size.small / 2,
                            color = background
                        )
                    }
                }
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
            navigateUp = { }
        )
    }
}