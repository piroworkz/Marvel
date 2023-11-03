package com.luna.marvel.app.ui.screens.anims

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import com.luna.marvel.app.ui.screens.anims.AnimationState.FINISH
import com.luna.marvel.app.ui.screens.anims.AnimationState.IDLE
import com.luna.marvel.app.ui.screens.anims.AnimationState.START

class RotatingScalingAnimation(
    val state: MutableState<AnimationState>,
    val scale: Animatable<Float, AnimationVector1D>,
    val rotate: Animatable<Float, AnimationVector1D>,
) {

    fun finish() {
        state.value = FINISH
    }

    fun start() {
        state.value = START
    }

    fun idle() {
        state.value = IDLE
    }

    suspend fun animateRotation(durationMillis: Int = 1000) {
        when (state.value) {
            IDLE -> rotate.snapTo(0F)
            FINISH -> rotate.animateTo(
                targetValue = 360F,
                animationSpec = tween(durationMillis)
            )

            START -> rotate.animateTo(
                targetValue = 0F,
                animationSpec = tween(durationMillis)
            )
        }
    }

    suspend fun animateScale(durationMillis: Int = 1000) {
        when (state.value) {
            IDLE -> {
                scale.snapTo(1F)
            }

            FINISH -> {
                scale.animateTo(
                    targetValue = 1F,
                    animationSpec = tween(durationMillis)
                )
            }

            START -> {
                scale.animateTo(
                    targetValue = 0F,
                    animationSpec = tween(durationMillis)
                )
            }
        }
    }

}