package com.luna.marvel.app.ui.screens.composables.master.views

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.menus.AppMenu
import com.luna.marvel.app.ui.screens.composables.MasterTags.MENU_BUTTON_TEXT
import com.luna.marvel.app.ui.screens.composables.MasterTags.MENU_COLUMN
import com.luna.marvel.app.ui.screens.composables.MasterTags.TOGGLE_ICON
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.onBackground
import com.luna.marvel.app.ui.theme.onPrimary
import com.luna.marvel.app.ui.theme.primary


@Composable
@OptIn(ExperimentalFoundationApi::class)
fun PagerCardView(
    title: String?,
    menu: List<AppMenu>,
    imagePath: String?,
    pagerState: PagerState,
    page: Int,
    onClick: (Destination?) -> Unit
) {

    val height = (LocalConfiguration.current.screenHeightDp * .66F)
    var showButtons by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .sizeIn(maxHeight = height.dp)
            .padding(vertical = Dimens.Size.medium)
            .graphicsLayer {
                resizeOnSnap(pagerState = pagerState, page = page)
            }
            .clip(RoundedCornerShape(Dimens.Size.medium))
            .background(onBackground),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = if (imagePath.isNullOrEmpty()) R.drawable.placeholder else imagePath,
            modifier = Modifier
                .fillMaxSize(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent)
                .align(Alignment.BottomCenter)
                .semantics { contentDescription = "PAGE# $page" },
            shape = Dimens.Shape.menuCard,
            elevation = CardDefaults.cardElevation(Dimens.Size.small)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(primary)
                    .padding(Dimens.Size.small),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = title ?: "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(.9F),
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center,
                        color = onPrimary
                    )
                )

                IconButton(
                    onClick = { showButtons = !showButtons },
                    modifier = Modifier
                        .testTag(TOGGLE_ICON)
                ) {
                    Icon(
                        imageVector = if (showButtons) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowUp,
                        contentDescription = Icons.Outlined.ArrowDropDown.name,
                        tint = onPrimary
                    )
                }
            }

            AnimatedContent(
                targetState = showButtons,
                label = "Buttons",
            ) {
                if (it) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag(MENU_COLUMN),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item {
                            Text(
                                text = "More About $title".uppercase(),
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
                        }
                        items(menu.size) { index: Int ->
                            val item = menu[index]
                            TextButton(item, onClick)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextButton(
    menu: AppMenu,
    onClick: (Destination?) -> Unit
) {
    TextButton(
        onClick = { onClick(menu.destination) },
        modifier = Modifier
            .testTag(MENU_BUTTON_TEXT)
    ) {
        Text(
            text = stringResource(menu.title).uppercase(),
            modifier = Modifier
                .fillMaxWidth(),
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.titleLarge.copy(
                color = onBackground
            )
        )
    }
}
