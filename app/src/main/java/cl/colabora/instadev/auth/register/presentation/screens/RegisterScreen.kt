package cl.colabora.instadev.auth.register.presentation.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.colabora.instadev.R
import cl.colabora.instadev.auth.login.domain.model.ContactType
import cl.colabora.instadev.core.ui.components.buttons.InstaPrimaryButton
import cl.colabora.instadev.core.ui.components.buttons.InstaSecondaryButton
import cl.colabora.instadev.core.ui.components.textfield.InstaSecondaryTextField
import cl.colabora.instadev.core.ui.components.texts.InstaPrimaryText
import cl.colabora.instadev.core.ui.components.texts.InstaSecondaryText
import cl.colabora.instadev.core.ui.components.texts.InstaTitleText

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()
    val contactType = registerViewModel.contactType.value
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(vertical = 32.dp)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.align(Alignment.Start),
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "",
            tint = Color.White
        )
        InstaTitleText(
            text = if (contactType == ContactType.MOBIL) {
                stringResource(R.string.register_screen_header_type_mobil)
            } else stringResource(R.string.register_screen_header_type_email),
        )
        InstaPrimaryText(
            text = if (contactType == ContactType.MOBIL) {
                stringResource(R.string.register_screen_body_type_movil)
            } else stringResource(R.string.register_screen_body_type_email),
        )
        Spacer(Modifier.height(16.dp))
        InstaSecondaryTextField(
            modifier = Modifier.fillMaxWidth(),
            value = uiState.mobilNumber,
            onValueChange = {},
            label = if (contactType == ContactType.MOBIL) {
                stringResource(R.string.register_screen_textfield_type_movil)
            } else stringResource(R.string.register_screen_textfield_type_email)
        )
        Spacer(Modifier.height(8.dp))
        InstaSecondaryText(
            text = if (contactType == ContactType.MOBIL) {
                stringResource(R.string.register_screen_bodysmall_type_movil)
            } else stringResource(R.string.register_screen_bodysmall_type_email),
            fontSize = 14.sp
        )
        Spacer(Modifier.height(16.dp))
        InstaPrimaryButton(modifier = Modifier.fillMaxWidth(), onClick = {}, text = stringResource(R.string.register_screen_primarybutton))
        InstaSecondaryButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = { registerViewModel.toggleContactType() },
            text = if (contactType == ContactType.MOBIL) {
                stringResource(R.string.register_screen_secondarybutton_type_movil)
            } else stringResource(R.string.register_screen_secondarybutton_type_email)
        )
        Spacer(Modifier.weight(1f))
        InstaSecondaryText(
            text = stringResource(R.string.register_screen_footer_label),
            fontSize = 12.sp
        )
    }
}