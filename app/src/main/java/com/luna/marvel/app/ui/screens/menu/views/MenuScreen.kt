package com.luna.marvel.app.ui.screens.menu.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.utils.AnimState.START
import com.luna.marvel.app.ui.screens.utils.AnimationEffects
import com.luna.marvel.app.ui.screens.utils.AnimationState
import com.luna.marvel.app.ui.screens.utils.rememberAnimationState
import com.luna.marvel.app.ui.screens.utils.shimmer
import kotlinx.coroutines.delay

@Composable
fun MenuScreen(
    navigate: (Destination) -> Unit
) {

    val menuAnimation = rememberAnimationState()
    var showShimmer by remember { mutableStateOf(true) }

    AnimationEffects(menuAnimation) { showShimmer = it }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.bkg_comics),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .scale(menuAnimation.scale.value)
                .rotate(menuAnimation.rotate.value)
        ) {
            val (character, comic, creator, event, series, story) = createRefs()
            val guideline25 = createGuidelineFromTop(0.25F)
            val guideline50 = createGuidelineFromTop(0.32F)
            val guideline64 = createGuidelineFromTop(0.68F)
            val guideline75 = createGuidelineFromTop(0.75F)
            val verticalCenter = createGuidelineFromStart(0.5F)

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(character) { characterConstraints(guideline50, comic) },
                image = R.drawable.btn_characters,
                onClick = { navigate(CharsGraph.Characters) }
            )

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(comic) { comicsConstraints(guideline25, verticalCenter) },
                image = R.drawable.btn_comics,
                onClick = { navigate(CharsGraph.Characters) }
            )

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(creator) { creatorsConstraints(guideline50, comic) },
                image = R.drawable.btn_creators,
                onClick = { navigate(CharsGraph.Characters) }
            )

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(event) { eventConstraints(guideline64, series) },
                image = R.drawable.btn_events,
                onClick = { navigate(CharsGraph.Characters) }
            )

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(series) { seriesConstraints(guideline75, verticalCenter) },
                image = R.drawable.btn_series,
                onClick = { navigate(CharsGraph.Characters) }
            )

            CircleButtonView(
                modifier = Modifier
                    .constrainAs(story) { storiesConstraints(guideline64, series) },
                image = R.drawable.btn_stories,
                onClick = { navigate(CharsGraph.Characters) }
            )

        }

        CircleButtonView(
            image = R.drawable.ic_button
        ) {
            if (menuAnimation.animStateState.value == START) {
                menuAnimation.finish()
            } else {
                menuAnimation.start()
            }
        }

        if (showShimmer) {
            Card(
                modifier = Modifier
                    .alpha(0.3F)
                    .size(180.dp)
                    .clip(CircleShape)
                    .blur(48.dp)
                    .shimmer(loading = true, duration = 500),
                shape = CircleShape
            ) {
            }
        }

    }
}



@Preview(
    showSystemUi = true,
)
@Composable
fun MenuPreview() {
    MaterialTheme {
        MenuScreen {}
    }
}