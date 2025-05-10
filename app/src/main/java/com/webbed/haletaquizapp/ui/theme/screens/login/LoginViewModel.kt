package com.webbed.haletaquizapp.ui.theme.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.webbed.haletaquizapp.data.RealmProvider.realm
import com.webbed.haletaquizapp.models.Admin
import io.realm.kotlin.ext.query

class LoginViewModel : ViewModel() {
    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var role by mutableStateOf<String?>(null)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onUsernameChange(newUsername: String) {
        username = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onRoleSelected(selectedRole: String) {
        role = selectedRole
    }

    fun validateAndNavigate(
        navigateToStudent: () -> Unit,
        navigateToAdmin: () -> Unit
    ) {
        if (role == null) {
            errorMessage = "ተማሪ / አስተዳዳሪ ሚለውን አልመረጡም"
            return
        }

        if (role == "student") {
            errorMessage = null
            navigateToStudent()
        } else if (role == "admin") {
            val admin = realm.query<Admin>("username == $0", username).first().find()
            if (admin != null && admin.password == password) {
                val canManageUsers = admin.canManageUsers
                val canManageQuizzes = admin.canManageQuizzes
                val canManageResources = admin.canManageResources
                navigateToAdmin()
            } else {
                errorMessage = "መለያ ወይም የይለፍ ቃል ተሳስቷል"
            }
        }
    }
}