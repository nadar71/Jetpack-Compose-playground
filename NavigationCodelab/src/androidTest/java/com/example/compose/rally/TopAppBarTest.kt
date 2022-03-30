package com.example.compose.rally

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test
import java.util.*

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_AccountsTab(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {
                },
                currentScreen = RallyScreen.Accounts
            )
        }
        // Thread.sleep(5000)
        composeTestRule.onRoot().printToLog("currentLabelExists")

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")


        // composeTestRule{.finder}{.assertion}{.action}
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

        /*composeTestRule
            .onNodeWithText(RallyScreen.Accounts.name.uppercase(Locale.getDefault()))
            .assertExists() // fails*/

        composeTestRule
            .onNode(
                hasText(RallyScreen.Accounts.name.uppercase()) and
                        hasParent(
                            hasContentDescription(RallyScreen.Accounts.name)
                        ),
                useUnmergedTree = true
            )
            .assertExists()
    }


    @Test
    fun rallyTopAppBarTest_BillsTab(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {
                },
                currentScreen = RallyScreen.Bills
            )
        }
        // Thread.sleep(5000)
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Bills.name)
            .assertIsSelected()
    }


    @Test
    fun rallyTopAppBarTest_OverviewTab(){
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = {
                },
                currentScreen = RallyScreen.Overview
            )
        }
        // Thread.sleep(5000)
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Overview.name)
            .assertIsSelected()
    }

}