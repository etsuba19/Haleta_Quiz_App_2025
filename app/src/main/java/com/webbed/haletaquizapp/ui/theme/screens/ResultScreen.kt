package com.example.geez.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import com.example.geez.R
import com.example.geez.ui.theme.components.DrawerMenu
import kotlinx.coroutines.launch

@Composable
fun ResultScreen(
    score: Int = 9,
    total: Int = 10,
    onDrawerItemClick: (String) -> Unit,
    onBackClick: () -> Unit,
    onNextClick: () -> Unit
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.fillMaxSize(),
                drawerContainerColor = Color.Transparent,
                windowInsets = WindowInsets(0)
            ) {
                DrawerMenu { item ->
                    onDrawerItemClick(item)
                    scope.launch { drawerState.close() }
                }
            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                // Top Menu Icon
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                // Logo
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(180.dp)
                    )
                }

                Spacer(modifier = Modifier.height(60.dp))

                // Score box
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFECEC), shape = RoundedCornerShape(20.dp))
                        .padding(vertical = 32.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "$score / $total", fontSize = 24.sp, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(75.dp))

                // Score message
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF8DDE0), shape = RoundedCornerShape(25.dp))
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("እርማት", fontSize = 18.sp, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFECEC), shape = RoundedCornerShape(20.dp))
                        .padding(vertical = 50.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "something correction", fontSize = 20.sp, color = Color.Black)
                }

                Spacer(modifier = Modifier.height(80.dp))

                // Buttons
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = onBackClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8DDE0)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 25.dp)
                    ) {
                        Text("መመለስ", color = Color.Black)
                    }
                    Button(
                        onClick = onNextClick,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF8DDE0)),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 25.dp)
                    ) {
                        Text("ቀጣይ", color = Color.Black)
                    }
                }
            }
        }
    }
}


