package com.webbed.haletaquizapp.ui.theme.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun TopicButton(
    text: String,
    height: Dp = 50.dp,
    widthFraction: Float = 0.85f,
    cornerRadius: Dp = 20.dp,
    fontSize: TextUnit = 18.sp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(widthFraction)
            .height(height)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFFDEEEF), Color(0xFFFBE7F0))
                ),
                shape = RoundedCornerShape(cornerRadius)
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF771F1E)
        )
    }
}
