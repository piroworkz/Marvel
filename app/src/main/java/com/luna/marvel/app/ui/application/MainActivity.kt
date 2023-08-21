package com.luna.marvel.app.ui.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luna.marvel.app.ui.navigation.Navigator
import com.luna.marvel.app.ui.theme.MarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MainObserver())
        setContent {
            MarvelTheme {
                Navigator()
            }
        }
    }
}