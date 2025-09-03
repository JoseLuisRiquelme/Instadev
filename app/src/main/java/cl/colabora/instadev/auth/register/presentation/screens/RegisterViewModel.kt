package cl.colabora.instadev.auth.register.presentation.screens

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun toggleContactType() {
        _uiState.update {
            it.copy(isPhoneMode = !it.isPhoneMode, value = "")
        }

    }

    fun onChangeMode(value: String) {
        _uiState.update {
            val isEnabled = if (it.isPhoneMode) {
                value.length >= 9
            } else {
                Patterns.EMAIL_ADDRESS.matcher(value).matches()
            }
            it.copy(isRegisterEnable = isEnabled, value = value)
        }
    }


}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isLoading: Boolean = false,
    val isRegisterEnable: Boolean = false

)