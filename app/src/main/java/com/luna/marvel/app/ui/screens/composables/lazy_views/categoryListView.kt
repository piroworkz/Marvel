package com.luna.marvel.app.ui.screens.composables.lazy_views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import coil.compose.AsyncImage
import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.primary
import com.luna.marvel.app.ui.theme.secondary

fun LazyGridScope.categoryListView(list: List<Item>) {
    items(list.size) { index: Int ->
        val item = list[index]
        Text(
            text = item.name,
            style = MaterialTheme.typography.titleMedium.copy(
                color = secondary,
                textAlign = TextAlign.Justify
            )
        )
    }
}

fun LazyGridScope.categorySubTitle(text: String) {
    item(span = { GridItemSpan(2) }) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Dimens.Size.medium,
                    horizontal = Dimens.Size.large
                ),
            style = MaterialTheme.typography.titleSmall.copy(
                color = primary,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Black
            )
        )
    }
}

fun LazyGridScope.images(images: List<Image>) {
    if (images.isEmpty())
        return

    items(images.size, span = { GridItemSpan(2) }) {
        val image = images[it]
        AsyncImage(
            model = image.path,
            contentDescription = image.path,
            modifier = Modifier
                .padding(Dimens.Size.small)
                .fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
    }
}

fun LazyGridScope.title(title: String) {
    item(span = { GridItemSpan(2) }) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Dimens.Size.medium,
                    horizontal = Dimens.Size.large
                ),
            style = MaterialTheme.typography.titleLarge.copy(
                color = background,
                textAlign = TextAlign.Justify,
                fontWeight = FontWeight.Black
            )
        )
    }
}