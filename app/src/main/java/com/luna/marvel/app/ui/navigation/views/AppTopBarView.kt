package com.luna.marvel.app.ui.navigation.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.navigation.graphs.MainGraph
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.primary

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
                    .padding(horizontal = Dimens.Size.medium),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        navigationIcon = {
            IconButton(onClick = onClick) {
                destination.icon?.let { Icon(imageVector = it, contentDescription = null) }
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = primary
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
        AppTopBarView(MainGraph.Characters) {}
    }
}