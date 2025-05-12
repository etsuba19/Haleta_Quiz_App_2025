package com.webbed.haletaquizapp.ui.screens.admin.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AdminDashboardViewModel : ViewModel() {
    
    // Function to handle logout
    fun logout() {
        viewModelScope.launch {
            // Clear any stored session data or preferences if needed
            // This would be where you'd handle any cleanup related to logging out
        }
    }
} 