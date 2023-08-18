package com.luna.marvel.app.ui.screens.characters.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.luna.domain.common.Item
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.BulletText
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.primary
import com.luna.marvel.app.ui.theme.secondary

@Composable
fun CharactersDetailScreen(
    destination: Destination,
    state: CharactersDetailViewModel.State,
    navigateUp: () -> Unit
) {

    val height = (LocalConfiguration.current.screenWidthDp.dp - Dimens.Size.xxLarge)

    AppScaffoldView(
        destination = destination,
        onNavIconClicked = navigateUp
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Size.medium)
        ) {

            item(span = { GridItemSpan(2) }) {
                AsyncImage(
                    model = state.character?.thumbnail?.path,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(Dimens.Size.medium)
                        .border(
                            width = 4.dp,
                            shape = CircleShape,
                            color = primary
                        )
                        .size(width = height, height = height)
                        .clip(CircleShape),
                    placeholder = painterResource(id = R.drawable.btn_bkg_a),
                    contentScale = ContentScale.Crop
                )
            }
            state.character?.description?.let(::itemDescription)

            state.character?.comics?.items?.let { items: List<Item> ->
                if (items.isEmpty()) return@let
                itemTitle("COMICS", state.character.name)
                itemsDetailList(items.map { c -> c.name })
            }

            state.character?.events?.items?.let { items: List<Item> ->
                if (items.isEmpty()) return@let
                itemTitle("EVENTS", state.character.name)
                itemsDetailList(items.map { c -> c.name })
            }

            state.character?.series?.items?.let { items: List<Item> ->
                if (items.isEmpty()) return@let
                itemTitle("SERIES", state.character.name)
                itemsDetailList(items.map { c -> c.name })
            }

            state.character?.stories?.items?.let { items: List<Item> ->
                if (items.isEmpty()) return@let
                itemTitle("STORIES", state.character.name)
                itemsDetailList(items.map { c -> c.name })
            }
        }
    }
}

private fun LazyGridScope.itemDescription(description: String) {
    item(
        span = { GridItemSpan(2) }
    ) {
        Text(
            text = description,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.Size.small),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = secondary,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Black
            )
        )
    }
}


private fun LazyGridScope.itemTitle(
    title: String,
    name: String?
) {
    item(
        span = { GridItemSpan(2) }
    ) {
        Text(
            text = "$name $title",
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.Size.small)
                .background(primary)
                .clip(Dimens.Shape.menuCard),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge.copy(
                color = background,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black
            )
        )
    }
}

private fun LazyGridScope.itemsDetailList(list: List<String>) {
    if (list.isEmpty())
        return
    items(list.size) {
        val item = list[it]
        BulletText(item)
    }
}


@Preview
@Composable
fun CharactersDetailPreview() {
    MaterialTheme {
        CharactersDetailScreen(
            CharsGraph.CharacterDetail,
            CharactersDetailViewModel.State()
        ) {}
    }
}