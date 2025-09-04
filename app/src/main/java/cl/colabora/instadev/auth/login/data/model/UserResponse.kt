package cl.colabora.instadev.auth.login.data.model

import cl.colabora.instadev.auth.login.domain.model.UserEntity
import cl.colabora.instadev.auth.login.domain.model.UserMode.*

data class UserResponse(
    val userId: String,
    val name: String,
    val nickname: String,
    val followers: Int,
    val followings: List<String>,
    val userType: Int
)

fun UserResponse.toDomain(): UserEntity {

    val userMode = when (userType) {
        REGULAR_USER.userType -> REGULAR_USER
        CONTENT_CREATOR_USER.userType -> CONTENT_CREATOR_USER
        COMPANY_USER.userType -> COMPANY_USER
        else -> REGULAR_USER
    }
    return UserEntity(
        userId = userId,
        name = name,
        nickname = nickname,
        followers = followers,
        followings = followings,
        userMode = userMode
    )
}