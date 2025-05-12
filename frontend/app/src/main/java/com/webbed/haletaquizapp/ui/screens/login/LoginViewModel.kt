package com.webbed.haletaquizapp.ui.screens.login

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.webbed.haletaquizapp.api.RetrofitClient
import com.webbed.haletaquizapp.data.TokenManager
import com.webbed.haletaquizapp.repository.AuthRepository
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenManager: TokenManager
) : AndroidViewModel(Application()) {
    
    var username by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    fun onUsernameChange(newUsername: String) {
        username = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun login(
        navigateToStudent: () -> Unit,
        navigateToAdmin: () -> Unit
    ) {
        if (username.isBlank() || password.isBlank()) {
            errorMessage = "የተጠቃሚ ስም እና የይለፍ ቃል ያስፈልጋል"
            return
        }

        viewModelScope.launch {
            try {
                isLoading = true
                errorMessage = null
                
                val response = authRepository.login(username, password)
                
                if (response.isSuccessful) {
                    response.body()?.let { loginResponse ->
                        // Save auth token
                        tokenManager.saveToken(loginResponse.access_token)
                        
                        // Save user role information
                        val isAdmin = loginResponse.user.isAdmin
                        
                        if (isAdmin) {
                            loginResponse.user.permissions?.let { permissions ->
                                tokenManager.saveUserRole(
                                    isAdmin = true,
                                    canManageUsers = permissions.canManageUsers,
                                    canManageQuizzes = permissions.canManageQuizzes,
                                    canManageResources = permissions.canManageResources
                                )
                            }
                            navigateToAdmin()
                        } else {
                            tokenManager.saveUserRole(isAdmin = false)
                            navigateToStudent()
                        }
                    }
                } else {
                    errorMessage = "መለያ ወይም የይለፍ ቃል ተሳስቷል"
                }
            } catch (e: IOException) {
                errorMessage = "ከአገልጋይ ጋር መገናኘት አልተቻለም"
            } catch (e: Exception) {
                errorMessage = "ያልታወቀ ስህተት: ${e.message}"
            } finally {
                isLoading = false
            }
        }
    }

    fun logout() {
        tokenManager.deleteToken()
    }
}