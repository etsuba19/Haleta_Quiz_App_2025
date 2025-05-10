package com.webbed.haletaquizapp.ui.theme.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.ui.theme.component.OptionCard
//import com.webbed.haletaquizapp.ui.theme.component.DrawerMenu

@Composable
fun Category(
    onDifficultySelected: () -> Unit,
    onDrawerItemClick: (String) -> Unit
) {
    var isDrawerOpen by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Main content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp)
        ) {
            // Menu Icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { isDrawerOpen = true }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        tint = Color.White,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.logoimg),
                    contentDescription = "Logo",
                    modifier = Modifier.size(180.dp)
                )
            }

            Spacer(modifier = Modifier.height(50.dp))

            OptionCard(title = "ጀማሪ", subtitle = "3 ጥያቄ * 3 ደቂቃ", onClick = onDifficultySelected)
            OptionCard(title = "መካከለኛ", subtitle = "3 ጥያቄ * 3 ደቂቃ", onClick = onDifficultySelected)
            OptionCard(title = "አዋቂ", subtitle = "3 ጥያቄ * 3 ደቂቃ", onClick = onDifficultySelected)

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 28.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Button(
                    onClick = { /* TODO: Return logic */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFF0DDE0),
                        contentColor = Color.Black
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp, vertical = 10.dp)
                ) {
                    Text(text = "ተመለስ", fontSize = 16.sp)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        // Overlay and Drawer content
        if (isDrawerOpen) {
            // Transparent black overlay to dismiss drawer
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { isDrawerOpen = false }
                    .background(Color.Black.copy(alpha = 0.3f))
            )

            // Drawer panel
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.65f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.menubg), // background for drawer
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


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Category (
        onDifficultySelected = {},
        onDrawerItemClick = {}
    )
}