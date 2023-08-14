package com.luna.marvel.app.ui.screens.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import com.luna.marvel.app.ui.screens.utils.AnimState.FINISH
import com.luna.marvel.app.ui.screens.utils.AnimState.IDLE
import com.luna.marvel.app.ui.screens.utils.AnimState.START

class OffsetAnimation(
    val animStateState: MutableState<AnimState>,
    val heightOffset: Animatable<Float, AnimationVector1D>,
) {
    fun finish() {
        animStateState.value = FINISH
    }

    fun start() {
        animStateState.value = START
    }

    fun idle() {
        animStateState.value = IDLE
    }

    suspend fun animateHeight(
        durationMillis: Int = 1000,
        height: Float
    ) {
        when (animStateState.value) {
            IDLE -> {
                heightOffset.snapTo(-height)
            }

            START -> {
                heightOffset.animateTo(
                    targetValue = -height,
                    animationSpec = tween(durationMillis)
                )
            }

            FINISH -> {
                heightOffset.animateTo(
                    targetValue = height,
                    animationSpec = tween(durationMillis)
                )
                idle()
            }
        }
    }
}