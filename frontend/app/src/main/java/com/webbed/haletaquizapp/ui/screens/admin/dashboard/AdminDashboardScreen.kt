package com.webbed.haletaquizapp.ui.screens.admin.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.component.CommonButton

@Composable
fun AdminDashboardScreen(
    navController: NavController,
    viewModel: AdminDashboardViewModel = viewModel()
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background image - reusing the same background as other screens
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo at the top
            Image(
                painter = painterResource(id = R.drawable.logoimg),
                contentDescription = "Logo",
                modifier = Modifier.size(120.dp)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            Text(
                text = "አስተዳዳሪ",
                color = Color(0xFFFAD6BF),
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Quiz List Button
            AdminMenuButton(
                text = "Quiz List",
                onClick = { navController.navigate("admin_quiz_list") }
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Resources List Button
            AdminMenuButton(
                text = "Resources List",
                onClick = { navController.navigate("admin_resources_list") }
            )
            
            Spacer(modifier = Modifier.height(48.dp))
            
            // Log Out Button
            Button(
                onClick = { 
                    viewModel.logout()
                    navController.navigate("login") {
                        popUpTo(0) { inclusive = true }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFAA0000)  // Red color for logout
                ),
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .height(48.dp)
            ) {
                Text("Log Out", fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun AdminMenuButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFC75D55)  // Using the reddish color from your UI
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .height(56.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
} 