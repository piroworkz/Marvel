package com.luna.marvel.app.ui.screens.stories.series

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Series
import com.luna.marvel.R
import com.luna.marvel.app.data.isAvailable
import com.luna.marvel.app.ui.navigation.graphs.StoriesGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.image
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background

@Composable
fun StorySeriesScreen(
    state: StorySeriesViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {
    AppScaffoldView(
        destination = StoriesGraph.StoriesSeries,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                state.series.isAvailable { seriesList: List<Series> ->

                    seriesList.forEach { series: Series ->

                        image(series.thumbnail.path)
                        title(series.title)

                        series.description?.let(::descriptionJustifiedText)

                        series.characters.items.isAvailable {
                            categorySubTitle(R.string.title_characters)
                            categoryListView(it)
                        }

                        series.comics.items.isAvailable {
                            categorySubTitle(R.string.title_comics)
                            categoryListView(it)
                        }

                        series.creators.items.isAvailable {
                            categorySubTitle(R.string.title_creators)
                            categoryListView(it)
                        }

                        series.events.items.isAvailable {
                            categorySubTitle(R.string.title_events)
                            categoryListView(it)
                        }

                        series.stories.items.isAvailable {
                            categorySubTitle(R.string.title_stories)
                            categoryListView(it)
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
            LoadingView(loading = state.loading)

            state.appError?.let {
                AppDialogScreen(message = it.appError) { sendEvent(AppEvent.NavigateUp) }
            }
        },
    )
}