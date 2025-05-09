package com.example.geez.ui.theme.screens.quiz

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class QuizViewModel : ViewModel() {

    private val _questionText = MutableStateFlow("እርስዎ በነበሩ ዓመታት እንዲህ ብለው ____")
    val questionText: StateFlow<String> = _questionText

    private val _options = MutableStateFlow(listOf("ወቅቱ", "ወቅታ", "ይነበር", "ነበር"))
    val options: StateFlow<List<String>> = _options

    private val _correctAnswer = MutableStateFlow("ይነበር")
    val correctAnswer: StateFlow<String> = _correctAnswer

    private val _selectedOption = MutableStateFlow<String?>(null)
    val selectedOption: StateFlow<String?> = _selectedOption

    fun selectOption(option: String) {
        _selectedOption.value = option
    }

    fun moveToNextQuestion() {
        // You can add logic here to load a new question
        _selectedOption.value = null
    }
}
