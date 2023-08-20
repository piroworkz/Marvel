package com.luna.marvel.app.ui.screens.comics.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.R
import com.luna.marvel.app.data.ifNotEmpty
import com.luna.marvel.app.ui.navigation.graphs.ComicsGraph
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categoryListView
import com.luna.marvel.app.ui.screens.composables.lazy_views.categorySubTitle
import com.luna.marvel.app.ui.screens.composables.lazy_views.descriptionJustifiedText
import com.luna.marvel.app.ui.screens.composables.lazy_views.images
import com.luna.marvel.app.ui.screens.composables.lazy_views.whiteDivider
import com.luna.marvel.app.ui.screens.composables.loading.LoadingView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun ComicDetailScreen(
    state: ComicDetailViewModel.State,
    navigateUp: () -> Unit
) {

    AppScaffoldView(
        destination = ComicsGraph.ComicsDetail,
        onNavIconClicked = navigateUp
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Size.medium)
        ) {

            state.comic?.images.ifNotEmpty { images ->
                images(images)
            }

            state.comic?.description?.let {
                val tagRegex = "<(.*?)>".toRegex()
                descriptionJustifiedText(it.replace(tagRegex, ""))

            }


            state.comic?.characters?.items.ifNotEmpty {
                categorySubTitle(R.string.title_characters)
                categoryListView(it)
            }

            state.comic?.events?.items.ifNotEmpty {
                categorySubTitle(R.string.title_events)
                categoryListView(it)
            }


            state.comic?.stories?.items.ifNotEmpty {
                categorySubTitle(R.string.title_stories)
                categoryListView(it)
            }

            whiteDivider()
        }
        LoadingView(loading = state.loading)
    }
}

@Preview
@Composable
fun ComicDetailPreview() {
    MarvelTheme {
        ComicDetailScreen(
            state = ComicDetailViewModel.State(),
            navigateUp = {}
        )
    }
}