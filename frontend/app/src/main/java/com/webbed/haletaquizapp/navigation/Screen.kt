package com.webbed.haletaquizapp.navigation

sealed class Screen(val route: String) {
    object Landing : Screen("landing_screen")
    object Login : Screen("login_screen")
    object Forgot : Screen("forgot_password_screen")
    object Signup : Screen("signup_screen")
    object Choice : Screen("choice_screen")
    object Security : Screen("security_questions_screen")
    object QuizLevel : Screen("category_screen")
    
    // Admin screens
    object AdminDashboard : Screen("admin_dashboard")
    object AdminQuizList : Screen("admin_quiz_list")
    object AdminResourceList : Screen("admin_resources_list")
    object AdminCreateQuiz : Screen("admin_create_quiz")
    object AdminEditQuiz : Screen("admin_edit_quiz/{quizId}")
    object AdminCreateResource : Screen("admin_create_resource")
    object AdminEditResource : Screen("admin_edit_resource/{resourceId}")
}