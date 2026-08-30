package com.example.myapplication.features.auth.domain.usecases
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.repository.AuthRepository

class LoginUseCase( private val repository: AuthRepository)  {
    suspend operator fun invoke(loginRequest: LoginRequest): NetworkResult<Unit> {
        return repository.login(loginRequest)
    }
}
