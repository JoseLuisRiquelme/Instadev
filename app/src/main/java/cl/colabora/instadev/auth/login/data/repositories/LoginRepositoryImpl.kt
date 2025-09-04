package cl.colabora.instadev.auth.login.data.repositories

import cl.colabora.instadev.auth.login.data.model.UserResponse
import cl.colabora.instadev.auth.login.data.model.toDomain
import cl.colabora.instadev.auth.login.domain.model.UserEntity
import cl.colabora.instadev.auth.login.domain.repositories.LoginRepository

class LoginRepositoryImpl(): LoginRepository {

    override fun doLogin(user: String, password: String): UserEntity {
        val userResponse: UserResponse= UserResponse("","","",10,listOf(""),0)
        return userResponse.toDomain()
    }
}