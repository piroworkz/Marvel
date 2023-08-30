package com.luna.marvel.app.ui.screens.characters.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.image
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens

@Composable
fun CharactersDetailScreen(
    state: CharactersDetailViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = CharsGraph.CharacterDetail,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {

                state.character?.thumbnail?.path?.let { image(it) }

                state.character?.description?.let {
                    descriptionJustifiedText(it)
                }

                state.character?.comics?.items.ifNotEmpty {
                    categorySubTitle(R.string.title_comics)
                    categoryListView(it)
                }

                state.character?.events?.items.ifNotEmpty {
                    categorySubTitle(R.string.title_events)
                    categoryListView(it)
                }

                state.character?.series?.items.ifNotEmpty {
                    categorySubTitle(R.string.title_series)
                    categoryListView(it)
                }

                state.character?.stories?.items.ifNotEmpty {
                    categorySubTitle(R.string.title_stories)
                    categoryListView(it)
                }

                whiteDivider()
            }
            LoadingView(loading = state.loading)

            state.appError?.let {
                AppDialogScreen(message = it.appError) { sendEvent(AppEvent.NavigateUp) }
            }
        },
    )
}

@Preview
@Composable
fun CharactersDetailPreview() {
    MaterialTheme {
        CharactersDetailScreen(
            CharactersDetailViewModel.State()
        ) {}
    }
}