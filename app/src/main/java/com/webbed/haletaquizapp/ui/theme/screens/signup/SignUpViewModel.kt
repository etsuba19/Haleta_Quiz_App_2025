package com.webbed.haletaquizapp.ui.theme.screens.signup

import androidx.lifecycle.ViewModel
import com.webbed.haletaquizapp.data.RealmProvider
import com.webbed.haletaquizapp.models.User
import io.realm.kotlin.ext.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()


    private val _resetA1 = MutableStateFlow("")
    val resetA1 = _resetA1.asStateFlow()


    private val _resetA2 = MutableStateFlow("")
    val resetA2 = _resetA2.asStateFlow()

    fun saveUserData() {
        CoroutineScope(Dispatchers.IO).launch {
            RealmProvider.realm.write {
                copyToRealm(User().apply {
                    username = _username.value
                    password = _password.value
                    resetA1 = _resetA1.value
                    resetA2 = _resetA2.value
                })
            }
        }
    }

    fun loadUserData(usernameInput: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val user = RealmProvider.realm.query<User>("username == $0", usernameInput).first().find()
            user?.let {
                _username.value = it.username
                _password.value = it.password
                _resetA1.value = it.resetA1
                _resetA2.value = it.resetA2
            }
        }
    }

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun onResetA1Changed(value: String) { _resetA1.value = value }

    fun onResetA2Changed(value: String) { _resetA2.value = value }

    fun validateAndNavigate(onSuccess: () -> Unit) {

        val username = _username.value.trim()
        val password = _password.value

        when {

            password.length < 6 -> {
                _errorMessage.value = "የይለፍ ቃል ቢያንስ 6 ፊደል ይኖረው አለበት"
            }
            else -> {
                _errorMessage.value = null
                onSuccess()
            }
        }
    }
}
