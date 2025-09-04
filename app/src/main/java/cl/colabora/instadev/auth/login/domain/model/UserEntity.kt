package cl.colabora.instadev.auth.login.domain.model

data class UserEntity(
    val userId: String,
    val name: String,
    val nickname: String,
    val followers:Int,
    val followings: List<String>,
    val userMode: UserMode
)
sealed class UserMode(val userType:Int){
    data object REGULAR_USER: UserMode(0)
    data object CONTENT_CREATOR_USER: UserMode(1)
    data object COMPANY_USER: UserMode(2)
}
