package com.luna.marvel.app.ui.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luna.marvel.app.ui.navigation.graphs.Destination
import com.luna.marvel.app.ui.theme.onBackground

@Composable
fun AppScaffoldView(
    destination: Destination?,
    onNavIconClicked: () -> Unit,
    content: @Composable BoxScope.() -> Unit
) {
    Scaffold(
        topBar = {
            AppTopBarView(
                destination = destination,
                onClick = onNavIconClicked
            )
        },
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(onBackground)
                .padding(it),
            Alignment.Center
        ) {
            content(this)
        }
    }
}