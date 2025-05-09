package com.webbed.haletaquizapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.webbed.haletaquizapp.ui.theme.themes.HaletaQuizAppTheme
import com.webbed.haletaquizapp.ui.theme.component.BackgroundWrapper
import com.webbed.haletaquizapp.ui.theme.screens.LandingScreen
import androidx.navigation.compose.rememberNavController
import com.webbed.haletaquizapp.ui.theme.navigation.Navigation



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaletaQuizAppTheme {
                BackgroundWrapper {
                    Navigation()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    val navController = rememberNavController()
    HaletaQuizAppTheme {
        LandingScreen(navController = navController)
    }
}