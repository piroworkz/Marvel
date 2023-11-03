package com.luna.marvel.app.ui.screens.composables.master

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luna.domain.MarvelItem
import com.luna.domain.common.Image
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.menus.AppMenu
import com.luna.marvel.app.ui.navigation.menus.characterMenu
import com.luna.marvel.app.ui.screens.common.MarvelEvent
import com.luna.marvel.app.ui.screens.common.MarvelEvent.NavigateTo
import com.luna.marvel.app.ui.screens.composables.AppScaffoldView
import com.luna.marvel.app.ui.screens.composables.MasterTags
import com.luna.marvel.app.ui.screens.composables.MasterTags.MASTER_SCREEN
import com.luna.marvel.app.ui.screens.composables.master.views.PagerCardView
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.primary

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MasterScreen(
    destination: Destination?,
    menu: List<AppMenu>,
    items: List<MarvelItem>,
    sendEvent: (MarvelEvent) -> Unit
) {
    val height = (LocalConfiguration.current.screenHeightDp * .17F).dp
    val pagerState: PagerState =
        rememberPagerState(pageCount = { if (items.isEmpty()) 1 else items.count() })

    AppScaffoldView(
        destination = destination,
        onNavIconClicked = { sendEvent(MarvelEvent.NavigateUp) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .testTag(MASTER_SCREEN),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_banner),
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(maxHeight = height),
                contentScale = ContentScale.Crop
            )

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .wrapContentSize(),
                pageSize = PageSize.Fill,
                contentPadding = PaddingValues(horizontal = Dimens.Size.xxLarge),
            ) { index: Int ->
                AnimatedContent(targetState = items.isEmpty(), label = "Loading") {
                    if (it) {
                        LoadingScreen()
                    } else {
                        val item =
                            if (items.isNotEmpty()) items[index] else null
                        PagerCardView(
                            title = item?.name,
                            menu = menu,
                            imagePath = item?.thumbnail?.path,
                            pagerState = pagerState,
                            page = index,
                            onClick = { dest: Destination? ->
                                sendEvent(NavigateTo(dest, item?.id))
                            }
                        )
                    }
                }
            }

            Image(
                painter = painterResource(id = R.drawable.img_banner),
                contentDescription = null,
                modifier = Modifier
                    .sizeIn(maxHeight = height),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
private fun LoadingScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(Dimens.Size.loading)
                .testTag(MasterTags.LOADING_VIEW),
            color = primary,
            strokeWidth = Dimens.Size.small,
        )
    }
}

@Preview
@Composable
fun CharactersMasterPreview() {
    MarvelTheme {
        MasterScreen(
            destination = CharsGraph.CharacterDetail,
            characterMenu,
            fakeChars
        ) {}
    }
}

val fakeChars = (0..13).map {
    MarvelItem(
        id = it,
        name = "Shelby Vazquez",
        thumbnail =
        Image(
            extension = "habitant",
            path = "https://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784.jpg"
        )
    )
}