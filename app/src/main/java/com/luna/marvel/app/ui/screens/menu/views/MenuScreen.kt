package com.luna.marvel.app.ui.screens.menu.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.luna.marvel.R
import com.luna.marvel.app.ui.navigation.graphs.CharsGraph
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.screens.composables.ComicStripeBackgroundView
import com.luna.marvel.app.ui.screens.utils.AnimState.START
import com.luna.marvel.app.ui.screens.utils.AnimationEffects
import com.luna.marvel.app.ui.screens.utils.rememberAnimationState

@Composable
fun MenuScreen(
    navigate: (Destination) -> Unit
) {

    val menuAnimation = rememberAnimationState()

    AnimationEffects(menuAnimation)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        ComicStripeBackgroundView()

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

        Image(
            painter = painterResource(id = R.drawable.ic_button),
            contentDescription = null,
            modifier = Modifier
                .size(128.dp)
                .clickable {
                    if (menuAnimation.animStateState.value == START) {
                        menuAnimation.finish()
                    } else {
                        menuAnimation.start()
                    }
                }
        )
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