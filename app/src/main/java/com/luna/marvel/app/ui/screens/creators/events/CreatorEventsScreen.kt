package com.luna.marvel.app.ui.screens.creators.events

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.domain.Event
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.CreatorsGraph
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.image
import com.luna.marvel.app.ui.screens.composables.lazy_views.title
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun CreatorEventsScreen(
    state: CreatorEventsViewModel.State,
    navigateUp: () -> Unit
) {
    AppScaffoldView(
        destination = CreatorsGraph.CreatorsEvents,
        onNavIconClicked = navigateUp
    ) {
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
                    descriptionJustifiedText(event.description)

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
                        categorySubTitle(R.string.title_stories)
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
    }
}


@Preview
@Composable
fun CreatorEventsPreview() {
    MarvelTheme {
        CreatorEventsScreen(
            state = CreatorEventsViewModel.State(),
            navigateUp = {}
        )
    }
}