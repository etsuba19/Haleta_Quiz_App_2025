package com.webbed.haletaquizapp.repository

import com.webbed.haletaquizapp.api.AuthApi
import com.webbed.haletaquizapp.api.LoginRequest
import com.webbed.haletaquizapp.api.LoginResponse
import com.webbed.haletaquizapp.api.RegisterRequest
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository @Inject constructor(
    private val authApi: AuthApi
) {
    suspend fun login(username: String, password: String): Response<LoginResponse> {
        return authApi.login(LoginRequest(username, password))
    }
    
    suspend fun register(username: String, password: String, resetA1: String, resetA2: String): Response<Any> {
        return authApi.register(RegisterRequest(username, password, resetA1, resetA2))
    }
} 