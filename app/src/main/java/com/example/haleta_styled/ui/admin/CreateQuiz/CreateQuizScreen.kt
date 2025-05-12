package com.example.haleta_styled.ui.admin.CreateQuiz

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haleta.ui.components.CommonButton

@Composable
fun CreateQuizScreen(viewModel: CreateQuizViewModel = viewModel()) {
    var quizTitle by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Create Quiz", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(value = quizTitle, onValueChange = { quizTitle = it }, label = { Text("Quiz Title") })
        Spacer(modifier = Modifier.height(8.dp))
        CommonButton(text = "Create") {
            viewModel.create(quizTitle)
        }
    }
}
