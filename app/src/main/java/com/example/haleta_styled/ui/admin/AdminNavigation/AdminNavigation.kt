package com.example.haleta_styled.ui.admin.AdminNavigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.NavController

fun NavGraphBuilder.adminNavigation(navController: NavController) {
    composable("adminDashboard") { AdminDashboardScreen() }
    composable("addQuestion") { AddQuestionScreen() }
    composable("uploadResource") { UploadResourceScreen() }
    composable("createQuiz") { CreateQuizScreen() }
}