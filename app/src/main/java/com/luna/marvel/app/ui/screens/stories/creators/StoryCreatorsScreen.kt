package com.luna.marvel.app.ui.screens.stories.creators

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Creator
import com.luna.marvel.R
import com.luna.marvel.app.data.isAvailable
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph
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
fun StoryCreatorsScreen(
    state: StoryCreatorsViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = StoriesGraph.StoriesCreators,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                state.creators.isAvailable { creators: List<Creator> ->

                    creators.forEach { creator: Creator ->

                        image(creator.thumbnail.path)

                        title(creator.fullName)

                        creator.comics.items.isAvailable {
                            categorySubTitle(R.string.title_comics)
                            categoryListView(it)
                        }

                        creator.events.items.isAvailable {
                            categorySubTitle(R.string.title_events)
                            categoryListView(it)
                        }

                        creator.series.items.isAvailable {
                            categorySubTitle(R.string.title_series)
                            categoryListView(it)
                        }

                        creator.stories.items.isAvailable {
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
