package com.example.myapplication.features.auth.domain.repository

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.models.SignupRequest

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): NetworkResult<Unit>
    suspend fun signup(signupRequest: SignupRequest): NetworkResult<Unit>
}