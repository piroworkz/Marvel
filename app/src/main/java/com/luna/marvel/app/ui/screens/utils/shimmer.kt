package com.luna.marvel.app.ui.screens.utils

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.grayDrk
import com.luna.marvel.app.ui.theme.grayLt
import com.luna.marvel.app.ui.theme.grayMd
import com.luna.marvel.app.ui.theme.secondary

fun Modifier.shimmer(loading: Boolean, duration: Int = 1000): Modifier = composed {
    var intSize by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "")
    val startOffset by transition.animateFloat(
        initialValue = -2 * intSize.width.toFloat(),
        targetValue = 2 * intSize.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = duration,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ), label = ""
    )
    if (loading) {
        background(getGrayGradientBrush(startOffset, intSize))
            .onGloballyPositioned { intSize = it.size }
    } else {
        background(background)
    }
}

fun getGrayGradientBrush(startOffset: Float, intSize: IntSize): Brush = Brush.linearGradient(
    colors = listOf(Color.White, grayMd, grayLt, grayMd, Color.White),
    start = Offset(startOffset, 0f),
    end = Offset(startOffset + intSize.width.toFloat(), intSize.height.toFloat()),
    tileMode = TileMode.Clamp
)