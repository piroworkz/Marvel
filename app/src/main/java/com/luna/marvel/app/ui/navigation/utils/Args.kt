package com.luna.marvel.app.ui.navigation.utils

import androidx.navigation.NavType

sealed class Args(val args: Pair<String, NavType<*>>)