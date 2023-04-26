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

//        FINDER:
//        composeTestRule.onNodeWithText("GOCHO")
        composeTestRule.onNodeWithText("gocho", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("g")
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")
    }
}