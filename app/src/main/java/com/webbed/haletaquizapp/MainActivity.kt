package com.webbed.haletaquizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.webbed.haletaquizapp.ui.screens.pronouns.PronounsScreen
import com.webbed.haletaquizapp.ui.theme.HaletaQuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaletaQuizAppTheme {
                PronounsScreen()
            }
        }
    }
}
