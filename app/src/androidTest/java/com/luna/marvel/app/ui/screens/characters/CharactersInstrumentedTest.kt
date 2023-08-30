package com.luna.marvel.app.ui.screens.characters

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import com.luna.marvel.app.data.MockWebServerRule
import com.luna.marvel.app.ui.application.MainActivity
import com.luna.marvel.app.ui.screens.common.clickCardMenuButton
import com.luna.marvel.app.ui.screens.common.navigateUp
import com.luna.marvel.app.ui.screens.common.onEmptyResultsDialog
import com.luna.marvel.app.ui.screens.common.pushMenuButton
import com.luna.marvel.app.ui.screens.common.splashScreen
import com.luna.marvel.app.ui.screens.common.toggleCardMenuVisibility
import com.luna.marvel.app.ui.screens.menu.MenuTags.CHARACTER_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.COMIC_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.CREATOR_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.EVENT_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.SERIES_BUTTON
import com.luna.marvel.app.ui.screens.menu.MenuTags.STORY_BUTTON
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CharactersInstrumentedTest {

    @get:Rule(order = 0)
    val hiltTestRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val mockWebServerRule = MockWebServerRule()

    @get:Rule(order = 2)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun shouldNavigateThroughCharactersNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(CHARACTER_BUTTON)
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("COMICS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("EVENTS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("SERIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("STORIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        activity.finish()
    }

    @Test
    fun shouldNavigateThroughComicsNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(COMIC_BUTTON)
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CHARACTERS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CREATORS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("EVENTS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("STORIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        activity.finish()
    }

    @Test
    fun shouldNavigateThroughCreatorsNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(CREATOR_BUTTON)
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("COMICS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("EVENTS")
        onEmptyResultsDialog()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("SERIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("STORIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        activity.finish()
    }

    @Test
    fun shouldNavigateThroughEventsNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(EVENT_BUTTON)
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CHARACTERS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("COMICS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CREATORS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("SERIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("STORIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        activity.finish()
    }


    @Test
    fun shouldNavigateThroughSeriesNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(SERIES_BUTTON)
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CHARACTERS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("COMICS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("CREATORS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("EVENTS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()
        toggleCardMenuVisibility()
        clickCardMenuButton("STORIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()
        activity.finish()
    }

    @Test
    fun shouldNavigateThroughStoriesNavigationGraph(): Unit = with(composeTestRule) {
        splashScreen()
        pushMenuButton(STORY_BUTTON)
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("DETAILS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("CHARACTERS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("COMICS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("CREATORS")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("EVENTS")
        onRoot(useUnmergedTree = true)
        onEmptyResultsDialog()
        waitForIdle()

        toggleCardMenuVisibility()
        clickCardMenuButton("SERIES")
        onRoot(useUnmergedTree = true)
        navigateUp()
        waitForIdle()

        activity.finish()
    }

}