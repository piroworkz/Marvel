@file:Suppress("unused")

package com.luna.marvel.app.ui.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.unit.dp

sealed interface Dimens {
    data object Size : Dimens {
        val small = 8.dp
        val medium = 16.dp
        val large = 24.dp
        val xLarge = 32.dp
        val xxLarge = 48.dp
    }

    data object Shape : Dimens {
        val menuCard = CutCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomStart = 0.dp,
            bottomEnd = Size.xLarge
        )
    }
}