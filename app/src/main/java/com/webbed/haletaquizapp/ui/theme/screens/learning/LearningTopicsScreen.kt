package com.webbed.haletaquizapp.ui.theme.screens.learning

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.ui.theme.component.TopicButton

@Composable
fun LearningTopicsScreen(viewModel: LearningTopicsViewModel) {
    val isDrawerOpen = viewModel.isDrawerOpen.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            // Menu Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { viewModel.openDrawer() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(180.dp)
                    .width(220.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val buttonHeight = 44.dp

            listOf(
                "መስሎችን - Pronouns" to "Pronouns",
                "ግሶ - Verbs" to "Verbs",
                "ስም - Nouns" to "Nouns",
                "ቅድመ - Adjectives" to "Adjectives",
                "አካል - Numbers" to "Numbers"
            ).forEach { (label, topic) ->
                TopicButton(text = label, height = buttonHeight) {
                    viewModel.onTopicClick(topic)
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            // Smaller "Back" button
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
            ) {
                TopicButton(text = "ተመላሽ", height = 36.dp) {
                    viewModel.onBack()
                }
            }
        }

        // Overlay and Drawer
        if (isDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { viewModel.closeDrawer() }
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.65f)
            ) {
                // Menu background only on 65%
                Image(
                    painter = painterResource(id = R.drawable.menubg),
                    contentDescription = "Menu BG",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    IconButton(
                        onClick = { viewModel.closeDrawer() },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "Close",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    listOf("Option 1", "Option 2", "Option 3", "Option 4").forEach { label ->
                        Button(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(44.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFCE8EE))
                        ) {
                            Text(text = label, fontSize = 15.sp, color = Color(0xFF771F1E))
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}
