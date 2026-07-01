package es.ai_context_benchmark

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import es.ai_context_benchmark.ui.theme.AicontextbenchmarkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AicontextbenchmarkTheme {
                LoginTokenApp()
            }
        }
    }
}

private enum class LoginTokenScreen {
    Login,
    Result
}

@Composable
fun LoginTokenApp(modifier: Modifier = Modifier) {
    var currentScreen by remember { mutableStateOf(LoginTokenScreen.Login) }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        when (currentScreen) {
            LoginTokenScreen.Login -> LoginScreen(
                username = username,
                password = password,
                onUsernameChange = { username = it },
                onPasswordChange = { password = it },
                onLoginClick = { currentScreen = LoginTokenScreen.Result },
                modifier = Modifier.padding(innerPadding)
            )

            LoginTokenScreen.Result -> ResultScreen(
                username = username,
                password = password,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
private fun LoginScreen(
    username: String,
    password: String,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = stringResource(R.string.login_poc_title))
        Text(text = stringResource(R.string.login_heading))
        OutlinedTextField(
            value = username,
            onValueChange = onUsernameChange,
            label = { Text(text = stringResource(R.string.username_label)) },
            modifier = Modifier
                .fillMaxWidth()
                .testTag(USERNAME_FIELD_TAG),
            singleLine = true
        )
        OutlinedTextField(
            value = password,
            onValueChange = onPasswordChange,
            label = { Text(text = stringResource(R.string.password_label)) },
            modifier = Modifier
                .fillMaxWidth()
                .testTag(PASSWORD_FIELD_TAG),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = onLoginClick,
            modifier = Modifier.testTag(LOGIN_BUTTON_TAG)
        ) {
            Text(text = stringResource(R.string.login_button))
        }
    }
}

@Composable
private fun ResultScreen(
    username: String,
    password: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = stringResource(R.string.result_title))
        Text(text = stringResource(R.string.result_username_label, username))
        Text(text = stringResource(R.string.result_password_label, password))
    }
}

const val USERNAME_FIELD_TAG = "username_field"
const val PASSWORD_FIELD_TAG = "password_field"
const val LOGIN_BUTTON_TAG = "login_button"

@Preview(showBackground = true)
@Composable
private fun LoginTokenAppPreview() {
    AicontextbenchmarkTheme {
        LoginTokenApp()
    }
}
