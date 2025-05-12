package com.webbed.haletaquizapp.navigation

sealed class Screen(val route : String) {
    object Landing : Screen("LandingScreen")
    object Login : Screen("LoginScreen")
    object Forgot : Screen("ForgotPasswordScreen")
    object Signup : Screen("SignUpScreen")
    object Choice : Screen("ChoiceScreen")
//    object Security : screen("SecurityQuestionsScreen")
//    object QuizLevel : screen("CategoryScreen")
}