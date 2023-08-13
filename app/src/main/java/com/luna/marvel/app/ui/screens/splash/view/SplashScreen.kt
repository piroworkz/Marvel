package com.luna.marvel.app.ui.screens.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.luna.marvel.R
import com.luna.marvel.app.ui.theme.MarvelTheme

@Composable
fun SplashScreen(navigate: () -> Unit) {

    Box(
        modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bkg_comics),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        AnimationView { navigate() }
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