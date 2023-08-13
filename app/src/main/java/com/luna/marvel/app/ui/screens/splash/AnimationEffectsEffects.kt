package com.luna.marvel.app.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.AnimationVector2D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp

@Composable
fun AnimationEffectsEffects(
    animatedScale: Animatable<Float, AnimationVector1D>,
    animatedOffset: Animatable<Offset, AnimationVector2D>,
    animatedBlur: Animatable<Float, AnimationVector1D>,
    onAnimationFinish: () -> Unit,
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val duration = 2000

    LaunchedEffect(key1 = Unit) {
        animatedScale.animateTo(
            targetValue = 1F,
            animationSpec = tween(durationMillis = duration)
        ) {
            if (value == 1F) {
                onAnimationFinish()
            }
        }
    }
    LaunchedEffect(key1 = Unit, block = {
        animatedOffset.animateTo(
            targetValue = Offset(0F, screenHeight.value),
            animationSpec = tween(durationMillis = duration)
        )
    })
    LaunchedEffect(key1 = Unit, block = {
        animatedBlur.animateTo(
            targetValue = 25F,
            animationSpec = tween(durationMillis = duration)
        )
    })
}