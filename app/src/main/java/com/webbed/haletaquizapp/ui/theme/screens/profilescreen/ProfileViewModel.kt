package com.example.geez.ui.theme.screens.profilescreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel : ViewModel() {

    private val _userName = MutableStateFlow("ስምዎን")
    val userName: StateFlow<String> = _userName

    // You can add more logic for loading profile data here
}
