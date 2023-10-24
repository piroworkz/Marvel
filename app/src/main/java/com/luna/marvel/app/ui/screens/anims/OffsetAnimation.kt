package com.luna.marvel.app.ui.screens.anims

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import com.luna.marvel.app.ui.screens.anims.AnimationState.FINISH
import com.luna.marvel.app.ui.screens.anims.AnimationState.IDLE
import com.luna.marvel.app.ui.screens.anims.AnimationState.START

class OffsetAnimation(
    val animationStateState: MutableState<AnimationState>,
    val heightOffset: Animatable<Float, AnimationVector1D>,
) {

    init {
        finish()
    }

    fun finish() {
        animationStateState.value = FINISH
    }

    fun start() {
        animationStateState.value = START
    }

    fun idle() {
        animationStateState.value = IDLE
    }

    suspend fun animateHeight(
        durationMillis: Int = 1000,
        height: Float
    ) {
        when (animationStateState.value) {
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