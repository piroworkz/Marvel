package com.luna.marvel.app.ui.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luna.marvel.R
import com.luna.marvel.app.ui.screens.splash.SplashTags.BACKGROUND_STRIPES

@Composable
fun ComicStripeBackgroundView() {
    val height = (LocalConfiguration.current.screenHeightDp * .17F).dp
    Column(
        modifier = Modifier
            .fillMaxSize()
            .testTag(BACKGROUND_STRIPES),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_banner),
            contentDescription = null,
            modifier = Modifier
                .sizeIn(maxHeight = height),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart
        )

        Image(
            painter = painterResource(id = R.drawable.img_banner),
            contentDescription = null,
            modifier = Modifier
                .sizeIn(maxHeight = height),
            contentScale = ContentScale.Crop,
            alignment = Alignment.BottomEnd
        )
    }
}