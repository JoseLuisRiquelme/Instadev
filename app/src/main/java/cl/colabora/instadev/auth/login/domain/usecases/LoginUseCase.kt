package cl.colabora.instadev.auth.login.domain.usecases

import cl.colabora.instadev.auth.login.domain.repositories.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    operator fun invoke(value: String,password: String){
        if (value.contains("@hotmail.com")){
            return
        }
        val response = loginRepository.doLogin(value,password)
    }
}