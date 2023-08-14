package com.luna.marvel.app.ui.screens.menu

import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope


fun ConstrainScope.storiesConstraints(
    guideline64: ConstraintLayoutBaseScope.HorizontalAnchor,
    series: ConstrainedLayoutReference
) {
    top.linkTo(guideline64)
    bottom.linkTo(guideline64)
    end.linkTo(parent.end)
    start.linkTo(series.end)
}

fun ConstrainScope.seriesConstraints(
    guideline75: ConstraintLayoutBaseScope.HorizontalAnchor,
    verticalCenter: ConstraintLayoutBaseScope.VerticalAnchor
) {
    top.linkTo(guideline75)
    bottom.linkTo(guideline75)
    start.linkTo(verticalCenter)
    end.linkTo(verticalCenter)
}

fun ConstrainScope.eventConstraints(
    guideline64: ConstraintLayoutBaseScope.HorizontalAnchor,
    series: ConstrainedLayoutReference
) {
    top.linkTo(guideline64)
    bottom.linkTo(guideline64)
    start.linkTo(parent.start)
    end.linkTo(series.start)
}

fun ConstrainScope.creatorsConstraints(
    guideline50: ConstraintLayoutBaseScope.HorizontalAnchor,
    comic: ConstrainedLayoutReference
) {
    top.linkTo(guideline50)
    bottom.linkTo(guideline50)
    start.linkTo(comic.end)
    end.linkTo(parent.end)
}

fun ConstrainScope.comicsConstraints(
    guideline25: ConstraintLayoutBaseScope.HorizontalAnchor,
    verticalCenter: ConstraintLayoutBaseScope.VerticalAnchor
) {
    top.linkTo(guideline25)
    bottom.linkTo(guideline25)
    start.linkTo(verticalCenter)
    end.linkTo(verticalCenter)
}

fun ConstrainScope.characterConstraints(
    guideline50: ConstraintLayoutBaseScope.HorizontalAnchor,
    comic: ConstrainedLayoutReference
) {
    top.linkTo(guideline50)
    bottom.linkTo(guideline50)
    start.linkTo(parent.start)
    end.linkTo(comic.start)
}
