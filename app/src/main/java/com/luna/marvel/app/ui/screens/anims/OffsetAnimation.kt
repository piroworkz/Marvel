package com.luna.marvel.app.ui.screens.anims

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import com.luna.marvel.app.ui.screens.anims.AnimationState.FINISH
import com.luna.marvel.app.ui.screens.anims.AnimationState.IDLE
import com.luna.marvel.app.ui.screens.anims.AnimationState.START

class OffsetAnimation(
    val state: MutableState<AnimationState>,
    val heightOffset: Animatable<Float, AnimationVector1D>,
) {

    init {
        finish()
    }

    fun finish() {
        state.value = FINISH
    }

    fun start() {
        state.value = START
    }

    fun idle() {
        state.value = IDLE
    }

    suspend fun animateHeight(
        durationMillis: Int = 1000,
        height: Float
    ) {
        when (state.value) {
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