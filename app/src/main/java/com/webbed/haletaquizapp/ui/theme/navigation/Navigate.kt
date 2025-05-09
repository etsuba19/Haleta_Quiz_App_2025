package com.webbed.haletaquizapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.webbed.haletaquizapp.ui.theme.screens.*
import com.webbed.haletaquizapp.ui.theme.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()

//    NavHost(navController = navController, startDestination = Screen.Landing.route) {
//        composable(Screen.Login.route) {
//            LoginScreen(
//                onForgotPasswordClick = {
//                    navController.navigate(screen.Forgot.route)
//                },
//                onSignUpClick = {
//                    navController.navigate(screen.Signup.route)
//                },
//                navController = navController
//            )
//        }
//
//        composable(screen.Forgot.route) { ForgotPasswordScreen(navController) }
//        composable(screen.Signup.route) { SignUpScreen(navController) }
//        composable(screen.Landing.route) { LandingScreen(navController) }
//        composable(screen.Choice.route) { ChoiceScreen(navController) }
//        composable(screen.Security.route) { SecurityQuestionsScreen(navController) }
//    }
}