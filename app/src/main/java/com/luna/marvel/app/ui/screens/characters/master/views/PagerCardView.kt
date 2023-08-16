package com.luna.marvel.app.ui.screens.characters.master.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.luna.domain.Character
import com.luna.marvel.app.ui.application.log
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.characters.master.fakeChars
import com.luna.marvel.app.ui.screens.utils.AboutMenu
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.onBackground
import com.luna.marvel.app.ui.theme.primary

private val menuAboutMenus = listOf(
    AboutMenu.Detail,
    AboutMenu.Comics,
    AboutMenu.Events,
    AboutMenu.Series,
    AboutMenu.Stories
)

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PagerCardView(
    pagerState: PagerState,
    page: Int,
    character: Character?,
    onClick: (Destination?) -> Unit
) {

    var showButtons by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = Dimens.Size.medium)
            .graphicsLayer {
                resizeOnSnap(pagerState = pagerState, page = page)
            }
            .clip(Dimens.Shape.menuCard)
            .background(primary),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = character?.thumbnail?.path ?: "",
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(background)
                .align(Alignment.BottomCenter),
            shape = Dimens.Shape.menuCard
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(background)
                    .padding(Dimens.Size.small),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = character?.name ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.9F),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )
                )

                IconButton(onClick = { showButtons = !showButtons }) {
                    Icon(
                        imageVector = if (showButtons) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowUp,
                        contentDescription = Icons.Outlined.ArrowDropDown.name,
                        modifier = Modifier,
                        tint = primary
                    )
                }
            }


            Text(
                text = character?.description ?: "",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(primary)
                    .padding(Dimens.Size.small),
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Black,
                    textAlign = TextAlign.Justify,
                )
            )

            AnimatedContent(
                targetState = showButtons,
                label = "Buttons",
            ) {
                if (it) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .verticalScroll(rememberScrollState())
                            .background(background),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "More About ${character?.name}".uppercase(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(onBackground)
                                .padding(Dimens.Size.small),
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontWeight = FontWeight.Black,
                                textAlign = TextAlign.Center,
                                color = background
                            )
                        )
                        menuAboutMenus.forEach {
                            TextButton(it, onClick)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextButton(
    menu: AboutMenu,
    onClick: (Destination?) -> Unit
) {
    TextButton(onClick = {
        menu.javaClass.simpleName.log("Clicked button")
        onClick(menu.destination)
    }) {
        Text(
            text = stringResource(menu.title).uppercase(),
            modifier = Modifier.fillMaxWidth(),
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge.copy(
                color = onBackground
            )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PagePreview() {
    val pagerState: PagerState = rememberPagerState(pageCount = fakeChars::count)
    MarvelTheme {
        PagerCardView(pagerState = pagerState, page = 0, character = fakeChars.first()) {}
    }
}
