package com.luna.marvel.app.ui.screens.characters.stories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Story
import com.luna.marvel.R
import com.luna.marvel.app.data.isAvailable
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background

@Composable
fun CharacterStoriesScreen(
    state: CharacterStoriesViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {
    AppScaffoldView(
        destination = CharsGraph.CharacterStories,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                if (state.stories.isNotEmpty()) {
                    state.stories.forEach { story: Story ->

                        title(story.title)
                        descriptionJustifiedText(story.description)

                        story.characters.items.isAvailable {
                            categorySubTitle(R.string.title_characters)
                            categoryListView(it)
                        }

                        story.comics.items.isAvailable {
                            categorySubTitle(R.string.title_comics)
                            categoryListView(it)
                        }

                        story.creators.items.isAvailable {
                            categorySubTitle(R.string.title_creators)
                            categoryListView(it)
                        }

                        story.events.items.isAvailable {
                            categorySubTitle(R.string.title_events)
                            categoryListView(it)
                        }

                        story.series.items.isAvailable {
                            categorySubTitle(R.string.title_series)
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