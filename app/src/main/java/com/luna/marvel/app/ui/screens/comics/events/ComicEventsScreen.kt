package com.luna.marvel.app.ui.screens.comics.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Event
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.image
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens

@Composable
fun ComicEventsScreen(
    state: ComicEventsViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = ComicsGraph.ComicsEvents,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                if (state.events.isNotEmpty()) {
                    state.events.forEach { event: Event ->

                        image(event.thumbnail.path)

                        title(event.title)

                        event.characters.items.ifNotEmpty {
                            categorySubTitle(R.string.title_characters)
                            categoryListView(it)
                        }

                        event.comics.items.ifNotEmpty {
                            categorySubTitle(R.string.title_comics)
                            categoryListView(it)
                        }

                        event.creators.items.ifNotEmpty {
                            categorySubTitle(R.string.title_creators)
                            categoryListView(it)
                        }

                        event.series.items.ifNotEmpty {
                            categorySubTitle(R.string.title_series)
                            categoryListView(it)
                        }

                        event.stories.items.ifNotEmpty {
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