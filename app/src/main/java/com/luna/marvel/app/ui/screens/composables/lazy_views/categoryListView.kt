package com.luna.marvel.app.ui.screens.composables.lazy_views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.luna.domain.common.Image
import com.luna.domain.common.Item
import com.luna.marvel.R
import com.luna.marvel.app.ui.screens.composables.BulletText
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.primary
import com.luna.marvel.app.ui.theme.secondary

fun LazyGridScope.categoryListView(list: List<Item>) {
    items(list.size) { index: Int ->
        val item = list[index]
        BulletText(text = item.name)
    }
}

fun LazyGridScope.categorySubTitle(text: Int) {
    item(span = { GridItemSpan(2) }) {
        Column {
            Divider(thickness = Dimens.Size.small / 4, color = secondary)
            Text(
                text = stringResource(id = text),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = Dimens.Size.medium,
                        horizontal = Dimens.Size.large
                    ),
                style = MaterialTheme.typography.titleMedium.copy(
                    color = primary,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Black
                )
            )
            Divider(thickness = Dimens.Size.small / 4, color = secondary)
        }
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
        Spacer(modifier = Modifier.padding(Dimens.Size.small))
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .background(primary)
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
        Spacer(modifier = Modifier.padding(Dimens.Size.small))
    }
}


fun LazyGridScope.image(path: String) {
    if (path.isEmpty())
        return

    item(span = { GridItemSpan(2) }) {
        val size = (LocalConfiguration.current.screenWidthDp.dp - Dimens.Size.xxLarge)
        AsyncImage(
            model = path,
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.Size.medium)
                .border(
                    width = 4.dp,
                    shape = CircleShape,
                    color = primary
                )
                .size(size = size)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.btn_bkg_a),
            contentScale = ContentScale.Crop
        )
    }
}

fun LazyGridScope.descriptionJustifiedText(text: String) {
    if (text.isEmpty())
        return
    item(span = { GridItemSpan(2) }) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = secondary,
                textAlign = TextAlign.Justify
            )
        )
    }
}

fun LazyGridScope.whiteDivider() {
    item(span = { GridItemSpan(2) }) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Dimens.Size.medium),
            thickness = Dimens.Size.small / 2,
            color = background
        )
    }
}