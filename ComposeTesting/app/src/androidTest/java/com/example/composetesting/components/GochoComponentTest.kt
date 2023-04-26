package com.example.composetesting.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class GochoComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            GochoComponent()
        }

//        FINDERS:
//        composeTestRule.onNodeWithText("GOCHO")
        composeTestRule.onNodeWithText("gocho", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("g")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

//        ACTIONS:
        composeTestRule.onNodeWithText("gocho", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("gocho").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("gocho").performScrollTo()
        composeTestRule.onNodeWithText("gocho").performScrollTo().performClick()
            .performTextInput("a") //multiple actions
        composeTestRule.onNodeWithText("gocho").performImeAction()
        composeTestRule.onNodeWithText("gocho")
            .performTextClearance() //borrar el texto de un TextField
        composeTestRule.onNodeWithText("gocho").performTextInput("Gocho, Bocho, Docho")
        composeTestRule.onNodeWithText("gocho").performTextReplacement("Kocho, Mocho, Kucho")


        //    ASSERTIONS:
        composeTestRule.onNodeWithText("gocho").assertExists()
        composeTestRule.onNodeWithText("gocho").assertDoesNotExist()
        composeTestRule.onNodeWithText("gocho").assertContentDescriptionEquals("gocho kochev")
        composeTestRule.onNodeWithText("gocho").assertContentDescriptionContains("gocho")
        composeTestRule.onNodeWithText("gocho").assertIsDisplayed()
        composeTestRule.onNodeWithText("gocho").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("gocho").assertIsEnabled()
        composeTestRule.onNodeWithText("gocho").assertIsNotEnabled()
        composeTestRule.onNodeWithText("gocho").assertIsSelected()
        composeTestRule.onNodeWithText("gocho").assertIsNotSelected()
        composeTestRule.onNodeWithText("gocho").assertIsFocused()
        composeTestRule.onNodeWithText("gocho").assertIsNotFocused()
        composeTestRule.onNodeWithText("gocho").assertIsOn() //checked
        composeTestRule.onNodeWithText("gocho").assertIsOff()//unchecked
        composeTestRule.onNodeWithText("gocho").assertTextEquals("")
        composeTestRule.onNodeWithText("gocho").assertTextContains("boch")
    }

}