package cl.colabora.instadev.auth.login.domain.repositories

import cl.colabora.instadev.auth.login.domain.model.UserEntity

interface LoginRepository {
    fun doLogin(user: String,password: String): UserEntity
}