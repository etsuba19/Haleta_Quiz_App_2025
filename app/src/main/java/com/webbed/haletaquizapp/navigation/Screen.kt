package com.webbed.haletaquizapp.navigation

sealed class Screen(val route : String) {
    object Landing : Screen("LandingScreen")
//    object Login : screen("LoginScreen")
//    object Forgot : screen("ForgotPasswordScreen")
//    object Signup : screen("SignUpScreen")
    object Choice : Screen("ChoiceScreen")
//    object Security : screen("SecurityQuestionsScreen")
//    object QuizLevel : screen("CategoryScreen")
}