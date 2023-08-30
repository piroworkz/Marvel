package com.luna.marvel.app.ui.screens.events.characters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Character
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.EventsGraph
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
fun EventCharactersScreen(
    state: EventCharactersViewModel.State,
    sendEvent: (AppEvent) -> Unit
) {

    AppScaffoldView(
        destination = EventsGraph.EventsCharacters,
        onNavIconClicked = { sendEvent(AppEvent.NavigateUp) },
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(Dimens.Size.medium)
            ) {
                state.characters.ifNotEmpty {
                    state.characters.forEach { character: Character ->

                        image(character.thumbnail.path)

                        if (character.description.isNotEmpty()) {
                            whiteDivider()
                            descriptionJustifiedText(character.description)
                            whiteDivider()
                        }

                        title(character.name)

                        character.comics.items.ifNotEmpty {
                            categorySubTitle(R.string.title_comics)
                            categoryListView(it)
                        }

                        character.events.items.ifNotEmpty {
                            categorySubTitle(R.string.title_events)
                            categoryListView(it)
                        }

                        character.series.items.ifNotEmpty {
                            categorySubTitle(R.string.title_series)
                            categoryListView(it)
                        }

                        character.stories.items.ifNotEmpty {
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