package com.webbed.haletaquizapp.ui.screens.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webbed.haletaquizapp.R

@Composable
fun ProfileScreen(onDrawerItemClick: (String) -> Unit) {
    var isDrawerOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top bar with hamburger menu
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { isDrawerOpen = true }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))

            Icon(
                painter = painterResource(id = R.drawable.baseline_account_circle_24),
                contentDescription = "Profile Icon",
                tint = Color(240, 221, 224),
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(26.dp))
            Text("ሰላማዊት", fontSize = 36.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                modifier = Modifier.padding(horizontal = 56.dp)
            ) {
                Text("መገለጫዎን ይቀይሩ", color = Color.White, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(240, 221, 224)),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(10.dp)
            ) {
                Text("▅ ▇ ▃", fontSize = 12.sp, color = Color(0xFF7C1626))
                Spacer(modifier = Modifier.width(16.dp))
                Text("የፈተና ማህደር", fontSize = 18.sp, color = Color(0xFF7C1626))
            }

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(240, 221, 224)),
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .padding(10.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                )
                {
                    Text("\uD83D\uDDA4 የተመረጡ ፈተናዎች", color = Color(0xFF7C1626), fontSize = 18.sp)
                }
            }

            Image(
                painter = painterResource(id = R.drawable.logoimg),
                contentDescription = "Footer Logo",
                modifier = Modifier
                    .size(170.dp)
                    .padding(top = 36.dp)
            )

            Button(
                onClick = { /* TODO */ },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(240, 221, 224)),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(16.dp)
            ) {
                Text("ከመለያ ውጣ", color = Color(0xFF7C1626), fontSize = 16.sp)
            }
        }

        // Drawer Overlay and Menu (copied from ResultScreen)
        if (isDrawerOpen) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { isDrawerOpen = false }
                    .background(Color.Black.copy(alpha = 0.3f))
            )

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
                        onClick = { isDrawerOpen = false },
                        modifier = Modifier.align(Alignment.Start)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "Close",
                            tint = Color.White
                        )
                    }

                    Spacer(modifier = Modifier.height(160.dp))

                    listOf("ጥያቄ - ፈተና ክብደት", "የፈተና ማህደር", "ንባብ", "መለያ").forEach { item ->
                        Button(
                            onClick = {
                                onDrawerItemClick(item)
                                isDrawerOpen = false
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(44.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFCE8EE))
                        ) {
                            Text(text = item, fontSize = 15.sp, color = Color(0xFF771F1E))
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

