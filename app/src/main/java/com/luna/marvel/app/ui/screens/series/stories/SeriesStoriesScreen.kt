package com.luna.marvel.app.ui.screens.series.stories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Story
import com.luna.marvel.R
import com.luna.marvel.app.data.isAvailable
import com.luna.marvel.app.ui.navigation.graphs.SeriesGraph
import com.luna.marvel.app.ui.screens.common.AppEvent
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.dialog.AppDialogScreen
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.image
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens

@Composable
fun SeriesStoriesScreen(
    state: SeriesStoriesViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = SeriesGraph.SeriesStories,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                state.stories.isAvailable { stories: List<Story> ->

                    stories.forEach { story: Story ->

                        image(story.thumbnail.path)
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
                            categorySubTitle(R.string.title_stories)
                            categoryListView(it)
                        }

                        story.series.items.isAvailable {
                            categorySubTitle(R.string.title_series)
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
