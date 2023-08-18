package com.luna.marvel.app.ui.screens.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PlainTooltipBox
import androidx.compose.material3.PlainTooltipState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.onBackground
import com.luna.marvel.app.ui.theme.secondary
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BulletText(text: String?) {
    val bullet = "\u2022"
    val scope = rememberCoroutineScope()
    val state by remember { mutableStateOf(PlainTooltipState()) }

    LaunchedEffect(key1 = state.isVisible, block = {
        if (state.isVisible) {
            delay(3000)
            state.dismiss()
        }
    })

    PlainTooltipBox(
        tooltip = { Text(text = "$bullet $text") },
        tooltipState = state,
        shape = RoundedCornerShape(Dimens.Size.small),
        containerColor = secondary,
        contentColor = onBackground
    ) {
        Text(
            text = "$bullet $text",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.Size.small)
                .clickable {
                    scope.launch {
                        if (state.isVisible) {
                            state.dismiss()
                        } else {
                            state.show()
                        }
                    }
                },
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = secondary,
                textAlign = TextAlign.Center,
            )
        )
    }


}