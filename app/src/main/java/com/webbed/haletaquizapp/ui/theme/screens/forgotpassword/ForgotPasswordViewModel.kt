package com.webbed.haletaquizapp.ui.theme.screens.forgotpassword

import androidx.lifecycle.ViewModel
import com.webbed.haletaquizapp.models.User
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class ForgotPasswordViewModel : ViewModel() {

    var username = MutableStateFlow("")
        private set

    var answer1 = MutableStateFlow("")
        private set

    var answer2 = MutableStateFlow("")
        private set

    private val realm: Realm

    init {
        val config = RealmConfiguration.Builder(schema = setOf(User::class))
            .name("users.realm")
            .build()
        realm = Realm.open(config)
    }

    fun onUsernameChange(newUsername: String) {
        username.value = newUsername
    }

    fun onAnswer1Change(newAnswer: String) {
        answer1.value = newAnswer
    }

    fun onAnswer2Change(newAnswer: String) {
        answer2.value = newAnswer
    }

    fun validateSecurityAnswers(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ) {
        val currentUsername = username.value.trim()
        val ans1 = answer1.value.trim()
        val ans2 = answer2.value.trim()

        CoroutineScope(Dispatchers.IO).launch {
            val user = realm.query<User>("username == $0", currentUsername)
                .first()
                .find()

            if (user == null) {
                onError("መለያ አልተገኘም")
            } else if (user.resetA1 == ans1 && user.resetA2 == ans2) {
                onSuccess()
            } else {
                onError("መልሶች ትክክል አይደሉም")
            }
        }
    }
}

