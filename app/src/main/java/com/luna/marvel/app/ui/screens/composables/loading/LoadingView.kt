package com.luna.marvel.app.ui.screens.composables.loading

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.app.ui.screens.composables.MasterTags.LOADING_VIEW
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.primary

@Composable
fun LoadingView(
    modifier: Modifier = Modifier,
    loading: Boolean,
) {
    if (!loading)
        return
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator(
            modifier = modifier
                .size(Dimens.Size.loading)
                .testTag(LOADING_VIEW),
            color = primary,
            strokeWidth = Dimens.Size.small,
        )
    }
}


@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun LoadingPreview() {
    MarvelTheme {
        LoadingView(loading = true)
    }
}
