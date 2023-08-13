package com.luna.marvel.app.ui.screens.splash.view

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.luna.marvel.R
import com.luna.marvel.app.ui.theme.Dimens

@Composable
fun AnimationView(onAnimationFinish: () -> Unit) {
    val animatedScale = remember { Animatable(0F) }
    val animatedOffset = remember { Animatable(Offset.Zero, Offset.VectorConverter) }
    val animatedBlur = remember { Animatable(0F) }

    AnimationEffectsEffects(
        animatedScale = animatedScale,
        animatedOffset = animatedOffset,
        animatedBlur = animatedBlur,
        onAnimationFinish = onAnimationFinish
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = Dimens.Size.small)
            .offset {
                IntOffset(
                    x = animatedOffset.value.x.toInt(),
                    y = animatedOffset.value.y.toInt()
                )
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bkg_stripes),
            contentDescription = null,
            modifier = Modifier
                .blur(
                    radius = animatedBlur.value.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
        )

        Image(
            painter = painterResource(id = R.drawable.bkg_stripes),
            contentDescription = null,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .scale(animatedScale.value)
                .blur(
                    radius = animatedBlur.value.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
        )
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = null,
            modifier = Modifier
                .scale(animatedScale.value)
        )
    }
}
