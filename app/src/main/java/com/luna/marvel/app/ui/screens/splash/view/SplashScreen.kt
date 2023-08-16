package com.luna.marvel.app.ui.screens.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luna.marvel.R
import com.luna.marvel.app.ui.application.log
import com.luna.marvel.app.ui.screens.utils.AnimState
import com.luna.marvel.app.ui.screens.utils.rememberOffsetAnimation
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun SplashScreen(navigate: () -> Unit) {

    val screenHeight = LocalConfiguration.current.screenHeightDp
    val logoAnimation = rememberOffsetAnimation()


    LaunchedEffect(key1 = logoAnimation.animStateState.value, block = {
        logoAnimation.animateHeight(
            durationMillis = 1500,
            height = screenHeight.toFloat()
        )
        if (logoAnimation.animStateState.value == AnimState.IDLE) {
            navigate()
        }
    })



    Box(
        modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bkg_comics),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Image(
            painter = painterResource(id = R.drawable.ic_button),
            contentDescription = null,
            modifier = Modifier
                .offset(0.dp, -screenHeight.dp)
                .offset(0.dp, logoAnimation.heightOffset.value.dp)
        )
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