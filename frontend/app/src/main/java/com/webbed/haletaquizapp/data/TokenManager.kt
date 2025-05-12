package com.webbed.haletaquizapp.data

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    private var prefs: SharedPreferences = context.getSharedPreferences(PREFS_TOKEN_FILE, Context.MODE_PRIVATE)
    
    companion object {
        private const val PREFS_TOKEN_FILE = "prefs_token_file"
        private const val USER_TOKEN = "user_token"
        private const val IS_ADMIN = "is_admin"
        private const val CAN_MANAGE_USERS = "can_manage_users"
        private const val CAN_MANAGE_QUIZZES = "can_manage_quizzes"
        private const val CAN_MANAGE_RESOURCES = "can_manage_resources"
        
        @Volatile
        private var instance: TokenManager? = null
        
        fun getInstance(context: Context): TokenManager {
            return instance ?: synchronized(this) {
                instance ?: TokenManager(context).also { instance = it }
            }
        }
    }
    
    fun saveToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    
    fun getToken(): String? {
        return prefs.getString(USER_TOKEN, null)
    }
    
    fun deleteToken() {
        val editor = prefs.edit()
        editor.clear()
        editor.apply()
    }
    
    fun saveUserRole(isAdmin: Boolean, 
                    canManageUsers: Boolean = false,
                    canManageQuizzes: Boolean = false,
                    canManageResources: Boolean = false) {
        val editor = prefs.edit()
        editor.putBoolean(IS_ADMIN, isAdmin)
        editor.putBoolean(CAN_MANAGE_USERS, canManageUsers)
        editor.putBoolean(CAN_MANAGE_QUIZZES, canManageQuizzes)
        editor.putBoolean(CAN_MANAGE_RESOURCES, canManageResources)
        editor.apply()
    }
    
    fun isAdmin(): Boolean {
        return prefs.getBoolean(IS_ADMIN, false)
    }
    
    fun canManageUsers(): Boolean {
        return prefs.getBoolean(CAN_MANAGE_USERS, false)
    }
    
    fun canManageQuizzes(): Boolean {
        return prefs.getBoolean(CAN_MANAGE_QUIZZES, false)
    }
    
    fun canManageResources(): Boolean {
        return prefs.getBoolean(CAN_MANAGE_RESOURCES, false)
    }
} 