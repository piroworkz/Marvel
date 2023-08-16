package com.luna.marvel.app.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luna.marvel.R

val marvelFamily = FontFamily(Font(R.font.marvel))
val oswaldFamily = FontFamily(
    listOf(
        Font(R.font.oswald_extra_light),
        Font(R.font.oswald_light),
        Font(R.font.oswald_regular),
        Font(R.font.oswald_medium),
        Font(R.font.oswald_semi_bold),
        Font(R.font.oswald_bold),
    )
)

val titleMarvel = TextStyle(
    fontFamily = marvelFamily,
    fontWeight = FontWeight.Black,
    fontSize = 32.sp,
)

val subTitleMarvel = TextStyle(
    fontFamily = marvelFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
)

val bodyMarvel = TextStyle(
    fontFamily = marvelFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 20.sp,
)


val Typography = Typography(
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Normal
    ),
).defaultFonFamily(oswaldFamily)

private fun Typography.defaultFonFamily(oswaldFamily: FontFamily): Typography {
    return copy(
        displayLarge = displayLarge.copy(fontFamily = oswaldFamily),
        displayMedium = displayMedium.copy(fontFamily = oswaldFamily),
        displaySmall = displaySmall.copy(fontFamily = oswaldFamily),
        headlineLarge = headlineLarge.copy(fontFamily = oswaldFamily),
        headlineMedium = headlineMedium.copy(fontFamily = oswaldFamily),
        headlineSmall = headlineSmall.copy(fontFamily = oswaldFamily),
        titleLarge = titleLarge.copy(fontFamily = oswaldFamily),
        titleMedium = titleMedium.copy(fontFamily = oswaldFamily),
        titleSmall = titleSmall.copy(fontFamily = oswaldFamily),
        bodyLarge = bodyLarge.copy(fontFamily = oswaldFamily),
        bodyMedium = bodyMedium.copy(fontFamily = oswaldFamily),
        bodySmall = bodySmall.copy(fontFamily = oswaldFamily),
        labelLarge = labelLarge.copy(fontFamily = oswaldFamily),
        labelMedium = labelMedium.copy(fontFamily = oswaldFamily),
        labelSmall = labelSmall.copy(fontFamily = oswaldFamily)
    )
}

//DisplayLarge .... Regular 57sp
//DisplayMedium .... Regular 45sp
//DisplaySmall .... Regular 36sp
//HeadlineLarge .... Regular 32sp
//HeadlineMedium .... Regular 28sp
//HeadlineSmall .... Regular 24sp
//TitleLarge .... Regular 22sp
//TitleMedium....  Medium 16sp
//TitleSmall....  Medium 14sp
//BodyLarge .... Regular 16sp
//BodyMedium .... Regular 14sp
//BodySmall .... Regular 12sp
//LabelLarge....  Medium 14sp
//LabelMedium....  Medium 12sp
//LabelSmall....  Medium 11sp