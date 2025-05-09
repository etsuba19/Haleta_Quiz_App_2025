package com.webbed.haletaquizapp.ui.theme.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*

@Composable
fun CommonButton(
    text: String,
    onClick: () -> Unit,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Color(0xFF460C16) else Color(0xFFF0DDE0),
            contentColor = if (isSelected) Color.White else Color(0xFF8B0000)
        ),
        shape = RoundedCornerShape(20.dp),
        modifier = modifier.width(200.dp)
            .height(40.dp)

    ) {
        Text(
            text = text,
            color = Color(0xFF8B0000),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,

            )
    }
}

