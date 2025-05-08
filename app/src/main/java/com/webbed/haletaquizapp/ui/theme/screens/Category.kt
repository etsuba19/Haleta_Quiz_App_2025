package com.webbed.haletaquizapp.ui.theme.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.Image
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
import com.webbed.haletaquizapp.ui.theme.component.DrawerMenu
import kotlinx.coroutines.launch
import java.util.Locale.Category

@Composable
fun Category(
    onDifficultySelected: () -> Unit,
    onDrawerItemClick: (String) -> Unit
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
    )
    {
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
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = {
                        scope.launch { drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(50.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
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