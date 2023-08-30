package com.luna.marvel.app.ui.screens.common

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDialog
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToNode
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.luna.marvel.app.ui.application.MainActivity
import com.luna.marvel.app.ui.screens.composables.MasterTags.APP_BAR
import com.luna.marvel.app.ui.screens.composables.MasterTags.APP_BAR_TITLE
import com.luna.marvel.app.ui.screens.composables.MasterTags.MASTER_SCREEN
import com.luna.marvel.app.ui.screens.composables.MasterTags.MENU_COLUMN
import com.luna.marvel.app.ui.screens.composables.MasterTags.NAV_ICON
import com.luna.marvel.app.ui.screens.composables.dialog.DialogTags
import com.luna.marvel.app.ui.screens.menu.MenuTags.MARVEL_MENU_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.MENU_SCREEN
import com.luna.marvel.app.ui.screens.splash.SplashTags.SPLASH_SCREEN

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.onEmptyResultsDialog() {
    onNode(isDialog(), true)
    onNodeWithContentDescription(DialogTags.GO_BACK_BUTTON).assertExists()
    onNodeWithContentDescription(DialogTags.GO_BACK_BUTTON).performClick()
}

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.navigateUp() {
    onNodeWithTag(APP_BAR).assertExists()
    onNodeWithTag(APP_BAR_TITLE).assertIsDisplayed()
    onNodeWithTag(NAV_ICON).performClick()
}

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.clickCardMenuButton(
    buttonTitle: String
) {
    onNodeWithTag(MENU_COLUMN).performScrollToNode(hasText(buttonTitle))
    onNodeWithText(buttonTitle).assertIsDisplayed()
    onNodeWithText(buttonTitle).performClick()
    waitForIdle()
}

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.toggleCardMenuVisibility() {
    onRoot(true)
    onNodeWithTag(MASTER_SCREEN, useUnmergedTree = true).assertIsDisplayed()
    onNodeWithContentDescription("PAGE# 0").onChildAt(1).performClick()
}

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.pushMenuButton(
    tag: String
) {
    onRoot(true)
    onNodeWithTag(MENU_SCREEN).assertIsDisplayed()
    onNodeWithTag(MARVEL_MENU_BUTTON).performClick()
    waitForIdle()
    onNodeWithTag(tag).performClick()
}

fun AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>.splashScreen() {
    onRoot(useUnmergedTree = true)
    onNodeWithTag(SPLASH_SCREEN).assertIsDisplayed()
    mainClock.advanceTimeBy(1500)
}