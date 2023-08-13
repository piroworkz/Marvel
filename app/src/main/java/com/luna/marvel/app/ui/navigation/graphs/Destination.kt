package com.luna.marvel.app.ui.navigation.graphs

import androidx.compose.ui.graphics.vector.ImageVector
import com.luna.marvel.app.ui.navigation.utils.Args

sealed class Destination(
    val route: String,
    val title: Int? = null,
    val icon: ImageVector? = null,
    val args: List<Args> = emptyList(),
)
