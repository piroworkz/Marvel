package com.luna.marvel.app.ui.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.primary

@Composable
fun TitleText(
    title: String,
    name: String?
) {
    Text(
        text = "$name $title",
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dimens.Size.small)
            .background(primary)
            .clip(Dimens.Shape.menuCard),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleLarge.copy(
            color = background,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Black
        )
    )
}