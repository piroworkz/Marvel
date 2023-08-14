package com.luna.marvel.app.ui.screens.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource

@Composable
fun CircleButtonView(
    modifier: Modifier = Modifier,
    image: Int,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clip(CircleShape)
            .clickable { onClick() },
        shape = CircleShape
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null
        )
    }
}