package es.ai_context_benchmark

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import es.ai_context_benchmark.ui.theme.AicontextbenchmarkTheme
import org.junit.Rule
import org.junit.Test

class LoginTokenAppTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun loginScreenShowsRequiredContent() {
        composeRule.setContent {
            AicontextbenchmarkTheme {
                LoginTokenApp()
            }
        }

        composeRule.onNodeWithText("Prueba de concepto de tokens").assertIsDisplayed()
        composeRule.onAllNodesWithText("Iniciar sesión").assertCountEquals(2)
        composeRule.onNodeWithTag(USERNAME_FIELD_TAG).assertIsDisplayed()
        composeRule.onNodeWithTag(PASSWORD_FIELD_TAG).assertIsDisplayed()
        composeRule.onNodeWithTag(LOGIN_BUTTON_TAG).assertIsDisplayed()
    }

    @Test
    fun loginButtonShowsEnteredCredentialsOnResultScreen() {
        composeRule.setContent {
            AicontextbenchmarkTheme {
                LoginTokenApp()
            }
        }

        composeRule.onNodeWithTag(USERNAME_FIELD_TAG).performTextInput("ana")
        composeRule.onNodeWithTag(PASSWORD_FIELD_TAG).performTextInput("secret")
        composeRule.onNodeWithTag(LOGIN_BUTTON_TAG).performClick()

        composeRule.onNodeWithText("Datos de inicio de sesión").assertIsDisplayed()
        composeRule.onNodeWithText("Usuario: ana").assertIsDisplayed()
        composeRule.onNodeWithText("Contraseña: secret").assertIsDisplayed()
    }
}
