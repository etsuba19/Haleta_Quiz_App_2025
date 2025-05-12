package com.example.haleta_styled.ui.admin.AddQuestion

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.haleta.ui.components.CommonButton

@Composable
fun AddQuestionScreen(viewModel: AddQuestionViewModel = viewModel()) {
    var question by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Add Question", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(value = question, onValueChange = { question = it }, label = { Text("Question") })
        Spacer(modifier = Modifier.height(8.dp))
        CommonButton(text = "Submit") {
            viewModel.addQuestion(question)
        }
    }
}