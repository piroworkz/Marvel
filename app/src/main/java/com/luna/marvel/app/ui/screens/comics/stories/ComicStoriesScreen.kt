package com.luna.marvel.app.ui.screens.comics.stories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.domain.Story
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
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
fun ComicStoriesScreen(
    state: ComicStoriesViewModel.State,
    navigateUp: () -> Unit
) {

    AppScaffoldView(
        destination = ComicsGraph.ComicsEvents,
        onNavIconClicked = navigateUp
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Size.medium)
        ) {
            if (state.characters.isNotEmpty()) {
                state.characters.forEach { story: Story ->

                    image(story.thumbnail.path)
                    title(story.title)

                    descriptionJustifiedText(story.description)

                    story.characters.items.ifNotEmpty {
                        categorySubTitle(R.string.title_characters)
                        categoryListView(it)
                    }

                    story.comics.items.ifNotEmpty {
                        categorySubTitle(R.string.title_comics)
                        categoryListView(it)
                    }

                    story.creators.items.ifNotEmpty {
                        categorySubTitle(R.string.title_creators)
                        categoryListView(it)
                    }

                    story.events.items.ifNotEmpty {
                        categorySubTitle(R.string.title_stories)
                        categoryListView(it)
                    }

                    story.series.items.ifNotEmpty {
                        categorySubTitle(R.string.title_series)
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
fun ComicStoriesPreview() {
    MarvelTheme {
        ComicStoriesScreen(
            state = ComicStoriesViewModel.State(),
            navigateUp = {}
        )
    }
}