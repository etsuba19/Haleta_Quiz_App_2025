package com.webbed.haletaquizapp.ui.screens.admin.resourcelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// We need a Resource model class, but since it doesn't exist yet, we'll use a simple data class
data class Resource(
    val id: String,
    val title: String,
    val content: String = "",
    val topicId: String = ""
)

class ResourceListViewModel : ViewModel() {
    
    private val _resources = MutableStateFlow<List<Resource>>(emptyList())
    val resources: StateFlow<List<Resource>> = _resources.asStateFlow()
    
    init {
        // Load sample resource data for now
        loadSampleResources()
    }
    
    private fun loadSampleResources() {
        // This is sample data. In a real implementation, you would load from a database
        val sampleResources = listOf(
            Resource(id = "1", title = "Mathematics Introduction"),
            Resource(id = "2", title = "Physics Basics"),
            Resource(id = "3", title = "Historical Events"),
            Resource(id = "4", title = "Literary Techniques"),
            Resource(id = "5", title = "Language Guide")
        )
        
        _resources.value = sampleResources
    }
    
    fun removeResource(resourceId: String) {
        viewModelScope.launch {
            // In a real implementation, you would remove from a database
            val updatedResources = _resources.value.filter { it.id != resourceId }
            _resources.value = updatedResources
        }
    }
} 