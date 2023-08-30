package com.luna.marvel.app.ui.screens.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun rememberAnimationState(
    initialState: AnimState = AnimState.START,
    animationState: MutableState<AnimState> = remember { mutableStateOf(initialState) },
    scale: Animatable<Float, AnimationVector1D> = remember { Animatable(0f) },
    rotation: Animatable<Float, AnimationVector1D> = remember { Animatable(0F) },
): AnimationState = remember {
    AnimationState(
        animStateState = animationState,
        scale = scale,
        rotate = rotation,
    )
}

@Composable
fun rememberOffsetAnimation(
    initialState: AnimState = AnimState.FINISH,
    animationState: MutableState<AnimState> = remember { mutableStateOf(initialState) },
    heightOffset: Animatable<Float, AnimationVector1D> = remember { Animatable(0F) }
): OffsetAnimation = remember { OffsetAnimation(animationState, heightOffset) }

@Composable
fun AnimationEffects(
    menuAnimation: AnimationState,
) {
    LaunchedEffect(key1 = menuAnimation.animStateState.value) {
        menuAnimation.animateScale(1000)
    }

    LaunchedEffect(key1 = menuAnimation.animStateState.value) {
        menuAnimation.animateRotation(1000)
    }
}
