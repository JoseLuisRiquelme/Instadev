package cl.colabora.instadev.auth.login.presentation.screens

import android.util.Log
import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChanged(email: String) {
        _uiState.update {
            it.copy(email = email)
        }
        verifyLogin()
    }

    fun onPasswordChanged(password: String) {
        _uiState.update {
            it.copy(password = password)
        }
        verifyLogin()
        Log.i("state","email:${uiState.value.email}\n" +
                "password:${uiState.value.password}\n" +
                "isLoading:${uiState.value.isLoading}\n" +
                "isLoginEnable:${uiState.value.isLoginEnable}")
    }

    private fun verifyLogin() {
        val enableLogin =
            isEmailValid(_uiState.value.email) && isPasswordValid(_uiState.value.password)
        _uiState.update {
            it.copy(isLoginEnable = enableLogin)
        }
    }

    private fun isEmailValid(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    private fun isPasswordValid(password: String) = password.length >= 6
}

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginEnable: Boolean = false
)