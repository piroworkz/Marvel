package com.luna.marvel.app.ui.navigation.graphs

import androidx.navigation.NavType

sealed class Args(val args: Pair<String, NavType<*>>) {
    data object ItemId : Args("id" to NavType.IntType)
}