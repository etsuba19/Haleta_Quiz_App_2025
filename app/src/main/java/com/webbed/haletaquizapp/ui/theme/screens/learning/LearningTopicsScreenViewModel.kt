package com.webbed.haletaquizapp.ui.theme.screens.learning

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LearningTopicsViewModel : ViewModel() {

    private val _isDrawerOpen = MutableStateFlow(false)
    val isDrawerOpen: StateFlow<Boolean> = _isDrawerOpen

    fun openDrawer() {
        _isDrawerOpen.value = true
    }

    fun closeDrawer() {
        _isDrawerOpen.value = false
    }

    fun onTopicClick(topic: String) {
        // Handle topic selection
    }

    fun onBack() {
        // Handle back button action
    }
}
