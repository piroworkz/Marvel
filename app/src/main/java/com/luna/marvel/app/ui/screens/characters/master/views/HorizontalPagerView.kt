package com.luna.marvel.app.ui.screens.characters.master.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.domain.Character
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.theme.Dimens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerView(
    pagerState: PagerState,
    characters: List<Character>?,
    onClick: (Destination?) -> Unit
) {

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .wrapContentSize(),
        pageSize = PageSize.Fill,
        contentPadding = PaddingValues(horizontal = Dimens.Size.xxLarge),
    ) { index: Int ->
        val character =
            if (!characters.isNullOrEmpty()) characters[index] else null
        PagerCardView(
            pagerState = pagerState,
            page = index,
            character = character,
            onClick = onClick
        )
    }
}