package com.luna.marvel.app.ui.screens.composables.master.views

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.ui.graphics.GraphicsLayerScope
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.layout.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
fun GraphicsLayerScope.resizeOnSnap(
    pagerState: PagerState,
    page: Int,
) {

    val pageOffset = (
            (pagerState.currentPage - page) + pagerState
                .currentPageOffsetFraction
            ).absoluteValue
    val fraction = 1f - pageOffset.coerceIn(0f, 1f)
    lerp(
        start = ScaleFactor(0.83f, 0.83f),
        stop = ScaleFactor(1f, 1f),
        fraction = fraction
    ).also { scaleFactor: ScaleFactor ->
        scaleX = scaleFactor.scaleX
        scaleY = scaleFactor.scaleY
    }
}
