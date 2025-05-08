package com.webbed.haletaquizapp.ui.theme.screens.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.ui.theme.component.DrawerMenu
import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(onDrawerItemClick: (String) -> Unit) {
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
                painter = painterResource(id = R.drawable.bgimg),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(44.dp))

                Icon(
                    painter = painterResource(id = R.drawable.baseline_account_circle_24),
                    contentDescription = "Profile Icon",
                    tint = Color(240, 221, 224),
                    modifier = Modifier.size(150.dp)
                )

                Spacer(modifier = Modifier.height(26.dp))
                Text("ስምዎን", fontSize = 34.sp, color = Color.White)
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
                    modifier = Modifier.padding(horizontal = 56.dp)
                ) {
                    Text("መለያዎን ያድሱ", color = Color.White, fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(240, 221, 224)),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(16.dp)
                ) {
                    Text("\uD83D\uDDA4 ፈተና ማህደር", color = Color.Black, fontSize = 18.sp)
                }

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(240, 221, 224)),
                    modifier = Modifier
                        .fillMaxWidth(0.6f)
                        .padding(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("▅ ▇ ▃", fontSize = 12.sp, color = Color.Black)
                        Text("ባለፈው ውጤት", fontSize = 18.sp, color = Color.Black)
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
                    Text("ከመለያ ውጣ", color = Color.Black, fontSize = 16.sp)
                }
            }
        }
    }
}
