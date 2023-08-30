package com.luna.marvel.app.ui.screens.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.composables.MasterTags.APP_BAR
import com.luna.marvel.app.ui.screens.composables.MasterTags.APP_BAR_TITLE
import com.luna.marvel.app.ui.screens.composables.MasterTags.NAV_ICON
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.primary
import com.luna.marvel.app.ui.theme.secondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBarView(
    destination: Destination?,
    onClick: () -> Unit
) {
    if (destination == null)
        return

    TopAppBar(
        title = {
            Text(
                text = stringResource(id = destination.title ?: 0),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.Size.medium)
                    .testTag(APP_BAR_TITLE),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = secondary
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .testTag(APP_BAR),
        navigationIcon = {
            IconButton(
                onClick = onClick,
                modifier = Modifier
                    .testTag(NAV_ICON)
            ) {
                destination.icon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        tint = secondary
                    )
                }
            }
        },
        colors = topAppBarColors(
            containerColor = primary,
        )
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun AppTopBarPreview() {
    MarvelTheme {
        AppTopBarView(CharsGraph.Characters) {}
    }
}