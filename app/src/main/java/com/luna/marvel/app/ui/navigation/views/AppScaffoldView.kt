package com.luna.marvel.app.ui.navigation.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.luna.marvel.app.ui.navigation.graphs.Destination

@OptIn(ExperimentalMaterial3Api::class)
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
                .padding(it),
            Alignment.Center
        ) {
            content(this)
        }
    }
}