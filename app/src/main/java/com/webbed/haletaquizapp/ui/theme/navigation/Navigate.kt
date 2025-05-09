//package com.webbed.haletaquizapp.ui.theme.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import com.webbed.haletaquizapp.ui.theme.screens.pronouns.PronounsScreen
//import com.webbed.haletaquizapp.ui.theme.screens.learning.LearningTopicsScreen
//import com.webbed.haletaquizapp.ui.theme.screens.learning.LearningTopicsViewModel
//
//@Composable
//fun AppNavigation(navController: NavHostController) {
//    NavHost(navController = navController, startDestination = "pronouns") {
//        composable("pronouns") {
//            PronounsScreen(navController = navController)
//        }
//        composable("learning") {
//            val viewModel: LearningTopicsViewModel = viewModel()
////            LearningTopicsScreen(viewModel = viewModel)
//        }
//    }
//}
