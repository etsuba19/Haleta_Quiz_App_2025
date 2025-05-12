package com.webbed.haletaquizapp.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.webbed.haletaquizapp.navigation.Screen
import com.webbed.haletaquizapp.ui.screens.LandingScreen
import com.webbed.haletaquizapp.ui.screens.forgotpassword.ForgotPasswordScreen
//import com.webbed.haletaquizapp.ui.screens.learning.LearningTopicsViewModel
import com.webbed.haletaquizapp.ui.screens.pronouns.PronounsScreen
import com.webbed.haletaquizapp.ui.screens.pronouns.PronounsScreen
import com.webbed.haletaquizapp.ui.screens.learning.LearningTopicsScreen
import com.webbed.haletaquizapp.ui.screens.learning.LearningTopicsViewModel
import com.webbed.haletaquizapp.ui.screens.login.LoginScreen
import com.webbed.haletaquizapp.ui.screens.signup.SignUpScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Landing.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onForgotPasswordClick = {
                    navController.navigate(Screen.Forgot.route)
                },
                onSignUpClick = {
                    navController.navigate(Screen.Signup.route)
                },
                navController = navController
            )
        }

        composable(Screen.Forgot.route) { ForgotPasswordScreen(navController) }
        composable(Screen.Signup.route) { SignUpScreen(navController) }
        composable(Screen.Landing.route) { LandingScreen(navController) }
//        composable(Screen.Choice.route) { ChoiceScreen(navController) }
//        composable(Screen.AdminPanel.route) {
//            AdminPanelScreen(navController = navController)
//        }

//        composable(Screen.UserList.route) {
//            UserListScreen(
//                users = mockUsers, // or state from a parent
//                onRemoveUser = { /* logic here */ },
//                onBack = { navController.popBackStack() }
//            )
//        }

    }
}
