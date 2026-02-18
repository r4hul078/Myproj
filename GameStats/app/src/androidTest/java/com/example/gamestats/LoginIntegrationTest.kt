package com.example.gamestats

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.example.gamestats.ui.theme.ExpenseTrackerTheme
import org.junit.Rule
import org.junit.Test

// Integration test for login screen input and click flow
class LoginIntegrationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLoginScreen_InputAndClick() {
        var loginClicked = false
        var capturedEmail = ""
        var capturedPassword = ""

        composeTestRule.setContent {
            ExpenseTrackerTheme {
                LoginScreen(
                    onLoginClick = { email, password ->
                        loginClicked = true
                        capturedEmail = email
                        capturedPassword = password
                    },
                    onSignUpClick = {},
                    onForgotPasswordClick = {}
                )
            }
        }

        // Enter email
        composeTestRule.onNodeWithText("Email").performTextInput("test@example.com")
        // Enter password
        composeTestRule.onNodeWithText("Password").performTextInput("password123")
        // Click login
        composeTestRule.onNodeWithText("Login").performClick()

        // Assert
        assert(loginClicked)
        assert(capturedEmail == "test@example.com")
        assert(capturedPassword == "password123")
    }
}
