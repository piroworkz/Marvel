package com.luna.marvel.app.ui.screens.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luna.marvel.R
import com.luna.marvel.app.ui.screens.composables.ComicStripeBackgroundView
import com.luna.marvel.app.ui.screens.menu.views.CircleButtonView
import com.luna.marvel.app.ui.screens.utils.AnimState
import com.luna.marvel.app.ui.screens.utils.rememberOffsetAnimation
import com.luna.marvel.app.ui.screens.utils.shimmer
import com.luna.marvel.app.ui.theme.MarvelTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigate: () -> Unit) {

    val screenHeight = LocalConfiguration.current.screenHeightDp
    val logoAnimation = rememberOffsetAnimation()
    var showShimmer by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = logoAnimation.animStateState.value, block = {
        logoAnimation.animateHeight(
            durationMillis = 1000,
            height = screenHeight.toFloat()
        )

        if (logoAnimation.animStateState.value == AnimState.IDLE) {
            showShimmer = true
            delay(500)
            showShimmer = false
            navigate()
        }
    })

    ComicStripeBackgroundView()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_button),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .offset(0.dp, -screenHeight.dp)
                .offset(0.dp, logoAnimation.heightOffset.value.dp)
        )

        if (showShimmer) {
            Image(
                painter = painterResource(id = R.drawable.ic_button),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
            )
            CircleButtonView(
                image = R.drawable.ic_button,
                modifier = Modifier
                    .alpha(0.3F)
                    .clip(CircleShape)
                    .blur(48.dp)
                    .size(128.dp)
                    .shimmer(loading = true, duration = 500),
            ) {
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SplashPreview() {
    MarvelTheme {
        SplashScreen {}
    }
}