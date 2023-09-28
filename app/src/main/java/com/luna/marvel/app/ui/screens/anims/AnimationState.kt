package com.luna.marvel.app.ui.screens.anims

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.runtime.MutableState
import com.luna.marvel.app.ui.screens.anims.AnimState.FINISH
import com.luna.marvel.app.ui.screens.anims.AnimState.IDLE
import com.luna.marvel.app.ui.screens.anims.AnimState.START

class AnimationState(
    val animStateState: MutableState<AnimState>,
    val scale: Animatable<Float, AnimationVector1D>,
    val rotate: Animatable<Float, AnimationVector1D>,
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

    suspend fun animateRotation(durationMillis: Int = 1000) {
        when (animStateState.value) {
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
        when (animStateState.value) {
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