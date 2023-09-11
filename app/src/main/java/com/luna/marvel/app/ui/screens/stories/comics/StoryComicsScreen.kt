package com.luna.marvel.app.ui.screens.stories.comics

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Comic
import com.luna.marvel.R
import com.luna.marvel.app.data.isAvailable
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph
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

@Composable
fun StoryComicsScreen(
    state: StoryComicsViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = StoriesGraph.StoriesComics,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                state.comics.isAvailable { comics: List<Comic> ->

                    comics.forEach { comic: Comic ->

                        images(comic.images)
                        title(comic.title)

                        comic.characters.items.isAvailable {
                            categorySubTitle(R.string.title_characters)
                            categoryListView(it)
                        }

                        comic.creators.items.isAvailable {
                            categorySubTitle(R.string.title_creators)
                            categoryListView(it)
                        }

                        comic.events.items.isAvailable {
                            categorySubTitle(R.string.title_events)
                            categoryListView(it)
                        }

                        comic.stories.items.isAvailable {
                            categorySubTitle(R.string.title_stories)
                            categoryListView(it)
                        }

                        whiteDivider()
                    }
                }
            }
            LoadingView(loading = state.loading)

            state.appError?.let {
                AppDialogScreen(message = it.appError) { sendEvent(AppEvent.NavigateUp) }
            }
        },
    )
}