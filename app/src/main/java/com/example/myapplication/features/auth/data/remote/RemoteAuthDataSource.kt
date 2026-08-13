package com.example.myapplication.features.auth.data.remote

import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.models.SignupRequest
import retrofit2.Response

class RemoteAuthDataSource (private val authApi: AuthApi) {
    suspend fun login(loginRequest: LoginRequest): Response<Unit> = authApi.login(loginRequest)
    suspend fun signup(signupRequest: SignupRequest):Response<Unit> = authApi.signup(signupRequest) ;
}