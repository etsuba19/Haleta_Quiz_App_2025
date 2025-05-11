package com.webbed.haletaquizapp.ui.screens.learning

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
import com.webbed.haletaquizapp.component.TopicButton

@Composable
fun LearningTopicsScreen(viewModel: LearningTopicsViewModel) {
    val isDrawerOpen = viewModel.isDrawerOpen.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {

        // 🔹 Background image
        Image(
            painter = painterResource(id = R.drawable.),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // 🔹 Main Content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 16.dp)
        ) {
            // 🔹 Menu Icon Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 13.dp),
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

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Logo
            Image(
                painter = painterResource(id = R.drawable.logoimg),
                contentDescription = "Logo",
                modifier = Modifier
                    .height(180.dp)
                    .width(220.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 🔹 Topic Buttons
            val buttonHeight = 39.dp
            val mainButtons = listOf(
                "መራሕያን - Pronouns" to "Pronouns",
                "ግስ - Verbs" to "Verbs",
                "ስም - Nouns" to "Nouns",
                "ቅጽል - Adjectives" to "Adjectives",
                "አሃዝ - Numbers" to "Numbers"
            )

            mainButtons.forEach { (label, topic) ->
                TopicButton(
                    text = label,
                    height = buttonHeight,
                    cornerRadius = 12.dp
                ) {
                    viewModel.onTopicClick(topic)
                }
                Spacer(modifier = Modifier.height(20.dp))
            }

            // 🔹 Back Button
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp)
            ) {
                TopicButton(
                    text = "ተመለስ",
                    height = buttonHeight,
                    widthFraction = 0.33f,
                    cornerRadius = 8.dp
                ) {
                    viewModel.onBack()
                }
            }
        }

        // 🔹 Overlay and Drawer
        if (isDrawerOpen) {
            // Semi-transparent background
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { viewModel.closeDrawer() }
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            // Drawer Content
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.65f)
            ) {
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

                    Spacer(modifier = Modifier.height(160.dp))

                    listOf("ጥያቄ - ፈተና ክብደት", "የፈተና ማህደር", "ንባብ", "መለያ").forEach { label ->
                        Button(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .height(39.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFCE8EE))
                        ) {
                            Text(text = label, fontSize = 15.sp, color = Color(0xFF771F1E))
                        }
                        Spacer(modifier = Modifier.height(25.dp))
                    }
                }
            }
        }
    }
}
