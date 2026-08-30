package com.example.myapplication.features.auth.data.repository
import android.util.Log
import com.example.myapplication.core.network.ErrorResponse
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.models.SignupRequest
import com.example.myapplication.features.auth.data.remote.RemoteAuthDataSource
import com.example.myapplication.features.auth.domain.repository.AuthRepository
import com.google.gson.Gson
import kotlin.jvm.java

class AuthRepositoryImpl(
    private val remoteAuthDataSource: RemoteAuthDataSource
) : AuthRepository {

    override suspend fun login(
        loginRequest: LoginRequest
    ): NetworkResult<Unit> {
        return try {
            val response = remoteAuthDataSource.login(loginRequest)
            val errorBody = response.errorBody()?.string()
            val errorResponse = Gson().fromJson(
                errorBody,
                ErrorResponse::class.java
            )

            if (response.isSuccessful) {

                NetworkResult.Success(Unit)

            } else {
                NetworkResult.Error(
                    errorResponse.message
                )
            }

        }catch (e: Exception){
            Log.d("TAG", "login repo 2: ${e.message}")

            NetworkResult.Error(
                e.message ?: "Something went wrong"
            )
        }
    }

    override suspend fun signup(
        signupRequest: SignupRequest
    ): NetworkResult<Unit> {
        return try {
            val response = remoteAuthDataSource.signup(signupRequest)
            val errorBody = response.errorBody()?.string()
            val errorResponse = Gson().fromJson(
                errorBody,
                ErrorResponse::class.java
            )

            if (response.isSuccessful) {

                NetworkResult.Success(Unit)

            } else {
                Log.d("TAG", "signup repo 1: ${response.message()}")

                NetworkResult.Error(
                    errorResponse.message
                )
            }

        }catch (e: Exception){

            NetworkResult.Error(
                e.message ?: "Something went wrong"
            )
        }
    }
}