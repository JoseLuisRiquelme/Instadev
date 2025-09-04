package cl.colabora.instadev.auth.login.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import cl.colabora.instadev.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.colabora.instadev.core.ui.components.buttons.InstaPrimaryButton
import cl.colabora.instadev.core.ui.components.buttons.InstaSecondaryButton
import cl.colabora.instadev.core.ui.components.textfield.InstaSecondaryTextField
import cl.colabora.instadev.core.ui.components.texts.InstaSecondaryText

//@Preview(showBackground = true)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel(), onNavigate: () -> Unit
) {

    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()
    Column(
        Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(vertical = 32.dp)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Text(
                text = stringResource(R.string.login_screen_header_language_country),
                color = MaterialTheme.colorScheme.onBackground
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
        Spacer(Modifier.weight(0.5f))
        Image(
            modifier = Modifier.size(72.dp),
            painter = painterResource(R.drawable.instadev_icon),
            contentDescription = ""
        )
        Spacer(Modifier.weight(0.5f))
        InstaSecondaryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.login_screen_textfield_email),
            value = uiState.email,
            onValueChange = { loginViewModel.onEmailChanged(it) })
        Spacer(Modifier.height(8.dp))
        InstaSecondaryTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.login_screen_textfield_password),
            value = uiState.password,
            onValueChange = { loginViewModel.onPasswordChanged(it) })
        Spacer(Modifier.height(8.dp))
        InstaPrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            enabled = uiState.isLoginEnable,
            text = stringResource(R.string.login_screen_button_login)
        )
        Spacer(Modifier.height(18.dp))
        InstaSecondaryText(
            text = stringResource(R.string.login_screen_text_forgot_password),
            color = MaterialTheme.colorScheme.onSurfaceVariant/*,
            fontSize=14.sp*/
        )
        Spacer(Modifier.weight(1f))
        InstaSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigate() }, text = stringResource(R.string.login_screen_button_signup)
        )
        Icon(
            modifier = Modifier.height(30.dp),
            painter = painterResource(R.drawable.meta_logo),
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}