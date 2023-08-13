package com.luna.marvel.app.ui.navigation.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.luna.marvel.app.ui.navigation.graphs.Destination

@Composable
fun AppScaffoldView(
    destination: Destination?,
    onNavIconClicked: () -> Unit,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppTopBarView(
            destination = destination,
            onClick = onNavIconClicked
        )
        content()
    }
}