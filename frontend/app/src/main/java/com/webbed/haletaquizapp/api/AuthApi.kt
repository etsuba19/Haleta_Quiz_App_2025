package com.webbed.haletaquizapp.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(
    val username: String,
    val password: String
)

data class RegisterRequest(
    val username: String,
    val password: String,
    val resetA1: String,
    val resetA2: String
)

data class LoginResponse(
    val access_token: String,
    val user: UserResponse
)

data class UserResponse(
    val id: String?,
    val username: String,
    val isAdmin: Boolean,
    val permissions: PermissionsResponse?
)

data class PermissionsResponse(
    val canManageUsers: Boolean,
    val canManageQuizzes: Boolean,
    val canManageResources: Boolean
)

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
    
    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<Any>
} 