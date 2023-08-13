package com.luna.marvel.app.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.navigation.views.AppScaffoldView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.onBackground
import com.luna.marvel.app.ui.theme.primary

private val menuItems = listOf(
    MainGraph.Characters to R.drawable.btn_bkg_a,
    MainGraph.Comics to R.drawable.btn_bkg_b,
    MainGraph.Creators to R.drawable.btn_bkg_c,
    MainGraph.Events to R.drawable.btn_bkg_d,
    MainGraph.Series to R.drawable.btn_bkg_a,
    MainGraph.Stories to R.drawable.btn_bkg_b
)

@Composable
fun MenuScreen() {

    AppScaffoldView(
        destination = MainGraph.Menu,
        onNavIconClicked = { }
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(menuItems.size) { index ->
                val (destination, image) = menuItems[index]
                MenuItem(
                    destination = destination,
                    image = image
                )
            }
        }

    }
}

@Composable
fun MenuItem(destination: Destination, image: Int) {

    Column(
        modifier = Modifier
            .padding(Dimens.Size.medium)
            .clip(Dimens.Shape.menuCard)
            .border(Dimens.Size.small / 4, primary, Dimens.Shape.menuCard),
    ) {
        destination.title?.let {
            Text(
                text = stringResource(id = it),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(background)
                    .padding(Dimens.Size.medium),
                color = onBackground,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.labelLarge,
            )
        }
        Divider(
            thickness = 2.dp,
            color = primary
        )
        Image(
            painter = painterResource(id = image),
            contentDescription = destination.route,
            Modifier.aspectRatio(.75F),
            contentScale = ContentScale.Crop
        )
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun MenuPreview() {
    MaterialTheme {
        MenuScreen()
    }
}