package com.example.myapplication.features.auth.domain.usecases
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.auth.domain.models.SignupRequest
import com.example.myapplication.features.auth.domain.repository.AuthRepository

class SignupUseCase( private val repository: AuthRepository)  {
    suspend operator fun invoke(signupRequest: SignupRequest): NetworkResult<Unit> {
        return repository.signup(signupRequest)
    }
}