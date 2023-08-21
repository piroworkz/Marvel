package com.luna.marvel.app.ui.screens.composables.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.luna.marvel.R
import com.luna.marvel.app.ui.theme.Dimens
import com.luna.marvel.app.ui.theme.MarvelTheme
import com.luna.marvel.app.ui.theme.background
import com.luna.marvel.app.ui.theme.onBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDialogScreen(
    message: String,
    onDismissRequest: () -> Unit
) {

    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.Size.medium),
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false,
            usePlatformDefaultWidth = false
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .clip(RoundedCornerShape(Dimens.Size.medium))
                .background(background),
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.bkg_dialog),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),
                contentScale = ContentScale.Crop
            )

            Column {

                Image(
                    painter = painterResource(id = R.drawable.ic_hydra),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(96.dp),
                )

                Text(
                    text = message,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.Size.medium),
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = onBackground,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )
                )

                Text(
                    text = "GO BACK",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(Dimens.Size.medium)
                        .clickable { onDismissRequest() },
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = onBackground,
                        fontWeight = FontWeight.Black,
                        textAlign = TextAlign.Center
                    )
                )
            }


        }

    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun AppDialogPreview() {
    MarvelTheme {
        AppDialogScreen(
            "Message test 123 456 789 101112 131415 161718 192021 222324 252627",
            onDismissRequest = {})
    }
}