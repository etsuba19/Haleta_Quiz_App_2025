package com.haleta.ui.screens.admin

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun UploadResourceScreen(viewModel: UploadResourceViewModel = viewModel()) {
    var title by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Upload Resource", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title") })
        Spacer(modifier = Modifier.height(8.dp))
        CommonButton(text = "Upload") {
            viewModel.upload(title)
        }
    }
}