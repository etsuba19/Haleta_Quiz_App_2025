package com.webbed.haletaquizapp.ui.theme.screens.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.*
import com.example.geez.ui.theme.screens.quiz.QuizViewModel
import com.webbed.haletaquizapp.R
//import com.webbed.haletaquizapp.ui.theme.screens.quiz.QuizViewModel

@Composable
fun QuizScreen(
    viewModel: QuizViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    onNextClick: () -> Unit
) {
    val questionText by viewModel.questionText.collectAsState()
    val options by viewModel.options.collectAsState()
    val correctAnswer by viewModel.correctAnswer.collectAsState()
    val selectedOption by viewModel.selectedOption.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.bg_img),
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Question
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFFFECEC), shape = RoundedCornerShape(20.dp))
                    .padding(vertical = 40.dp, horizontal = 20.dp)
            ) {
                Text(text = questionText, fontSize = 22.sp, color = Color.Black)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Options
            options.forEach { option ->
                val backgroundColor = when {
                    selectedOption == null -> Color(0xFFF8DDE0)
                    option == correctAnswer && selectedOption != null -> Color(0xFF4CAF50)
                    option == selectedOption && selectedOption != correctAnswer -> Color(0xFFFF5252)
                    else -> Color(0xFFF8DDE0)
                }

                Button(
                    onClick = { viewModel.selectOption(option) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(option, fontSize = 18.sp, color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {
                    viewModel.moveToNextQuestion()
                    onNextClick()
                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(240, 221, 224),
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(horizontal = 40.dp, vertical = 14.dp)
            ) {
                Text("ቀጣይ", fontSize = 16.sp)
            }
        }
    }
}
