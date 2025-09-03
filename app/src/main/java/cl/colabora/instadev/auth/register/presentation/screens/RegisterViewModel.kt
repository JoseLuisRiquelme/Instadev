package cl.colabora.instadev.auth.register.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import cl.colabora.instadev.auth.login.domain.model.ContactType
import cl.colabora.instadev.core.navegation.Register
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState
    var contactType= mutableStateOf(ContactType.MOBIL)
    fun toggleContactType(){
        contactType.value=if(contactType.value== ContactType.MOBIL)
            ContactType.EMAIL else ContactType.MOBIL
    }
}

data class RegisterUiState(
    val mobilNumber: String = "",
    val email: String = "",
    val isLoading: Boolean = false,
    val isRegisterEnable: Boolean = false

)