package cl.colabora.instadev.auth.register.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.colabora.instadev.R
import cl.colabora.instadev.core.ui.components.buttons.InstaPrimaryButton
import cl.colabora.instadev.core.ui.components.buttons.InstaSecondaryButton
import cl.colabora.instadev.core.ui.components.textfield.InstaSecondaryTextField
import cl.colabora.instadev.core.ui.components.texts.InstaPrimaryText
import cl.colabora.instadev.core.ui.components.texts.InstaSecondaryText
import cl.colabora.instadev.core.ui.components.texts.InstaTitleText

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel(), onNavigate: () -> Unit) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val subtitle: String
    val label: String
    val changeModeText: String
    val changeModeButton: String

    when (uiState.isPhoneMode) {
        true -> {
            title = stringResource(R.string.register_screen_header_type_mobil)
            subtitle = stringResource(R.string.register_screen_bodysmall_type_movil)
            label = stringResource(R.string.register_screen_textfield_type_movil)
            changeModeText = stringResource(R.string.register_screen_body_type_movil)
            changeModeButton = stringResource(R.string.register_screen_secondarybutton_type_email)
        }

        false -> {
            title = stringResource(R.string.register_screen_header_type_email)
            subtitle = stringResource(R.string.register_screen_bodysmall_type_email)
            label = stringResource(R.string.register_screen_textfield_type_email)
            changeModeText = stringResource(R.string.register_screen_body_type_email)
            changeModeButton = stringResource(R.string.register_screen_secondarybutton_type_movil)
        }
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 32.dp)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .align(Alignment.Start)
                .clickable {
                    onNavigate()
                },
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
        InstaTitleText(
            text = title,
        )
        InstaPrimaryText(
            text = subtitle,
        )
        Spacer(Modifier.height(16.dp))
        InstaSecondaryTextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.value,
            onValueChange = { registerViewModel.onChangeMode(it) },
            label = label
        )
        Spacer(Modifier.height(8.dp))
        InstaSecondaryText(
            text = changeModeText,
            fontSize = 14.sp
        )
        Spacer(Modifier.height(16.dp))
        InstaPrimaryButton(
            enabled = uiState.isRegisterEnable,
            modifier = Modifier.fillMaxWidth(),
            onClick = {},
            text = stringResource(R.string.register_screen_primarybutton)
        )
        InstaSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { registerViewModel.toggleContactType() },
            text = changeModeButton
        )
        Spacer(Modifier.weight(1f))
        InstaSecondaryText(
            text = stringResource(R.string.register_screen_footer_label),
            fontSize = 12.sp
        )
    }
}