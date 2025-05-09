package com.webbed.haletaquizapp.ui.theme.screens.learning

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LearningTopicsViewModel : ViewModel() {
    private val _isDrawerOpen = MutableStateFlow(false)
    val isDrawerOpen = _isDrawerOpen.asStateFlow()

    fun openDrawer() {
        _isDrawerOpen.value = true
    }

    fun closeDrawer() {
        _isDrawerOpen.value = false
    }

    fun onTopicClick(topic: String) {
        // Just for testing
        println("Topic clicked: $topic")
    }
}
