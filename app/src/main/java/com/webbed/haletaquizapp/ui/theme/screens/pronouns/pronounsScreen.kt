package com.webbed.haletaquizapp.ui.theme.screens.pronouns

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.webbed.haletaquizapp.R

@Composable
fun PronounsScreen() {
    val viewModel: PronounsViewModel = viewModel()
    val pronouns = viewModel.pronouns.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Push title down

            // Top header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF660000)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                )
                Text(
                    text = "መስሎችን - Pronouns",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Content box
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFCE8EE), shape = RoundedCornerShape(4.dp))
                    .padding(start = 24.dp, end = 16.dp, top = 12.dp, bottom = 88.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                val mainTextStyle = TextStyle(
                    fontSize = 16.sp,
                    color = Color(0xFF3A0C0C),
                    fontWeight = FontWeight.SemiBold
                )

                Text("መራሕያን መርሐ /መራ/ ከሚለው ግስ የተገኘ ሲሆን", style = mainTextStyle)
                Text("መሪዎች ፊታውራሪዎች የሚለውን ትርጉም ይይዛል።", style = mainTextStyle)
                Text("መራሕያን የሚባሉት በግእዝ ልሣን አስር ናቸው። እነርሱም፡-", style = mainTextStyle)

                pronouns.forEach { item ->
                    Text("${item.amharic} - ${item.translation}", style = mainTextStyle)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Static back button (no nav logic)
            Button(
                onClick = { /* No action yet */ },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .height(48.dp)
                    .width(120.dp)
                    .align(Alignment.Start)
            ) {
                Text("ተመለስ", color = Color(0xFF771F1E))
            }
        }
    }
}
