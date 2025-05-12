package com.webbed.haletaquizapp.ui.screens.admin.quizlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// We need a Quiz model class, but since it doesn't exist yet, we'll use a simple data class
data class Quiz(
    val id: String,
    val title: String,
    val description: String? = null
)

class QuizListViewModel : ViewModel() {
    
    private val _quizzes = MutableStateFlow<List<Quiz>>(emptyList())
    val quizzes: StateFlow<List<Quiz>> = _quizzes.asStateFlow()
    
    init {
        // Load sample quiz data for now
        loadSampleQuizzes()
    }
    
    private fun loadSampleQuizzes() {
        // This is sample data. In a real implementation, you would load from a database
        val sampleQuizzes = listOf(
            Quiz(id = "1", title = "Math Quiz - Beginner"),
            Quiz(id = "2", title = "Science Quiz - Intermediate"),
            Quiz(id = "3", title = "History Quiz - Expert"),
            Quiz(id = "4", title = "Literature Quiz - Beginner"),
            Quiz(id = "5", title = "Language Quiz - Intermediate")
        )
        
        _quizzes.value = sampleQuizzes
    }
    
    fun removeQuiz(quizId: String) {
        viewModelScope.launch {
            // In a real implementation, you would remove from a database
            val updatedQuizzes = _quizzes.value.filter { it.id != quizId }
            _quizzes.value = updatedQuizzes
        }
    }
} 