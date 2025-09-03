package cl.colabora.instadev.core.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.colabora.instadev.auth.login.presentation.screens.LoginScreen
import cl.colabora.instadev.auth.register.presentation.screens.RegisterScreen

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(onNavigate = {
                navController.navigate(Register)
            })
        }
        composable<Register> {
            RegisterScreen()
        }
    }
}