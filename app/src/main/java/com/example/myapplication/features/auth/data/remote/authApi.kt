package com.example.myapplication.features.auth.data.remote
import com.example.myapplication.core.network.NetworkConstants
import com.example.myapplication.core.network.NetworkConstants.signinEndPoint
import com.example.myapplication.core.network.NetworkConstants.signupEndPoint
import com.example.myapplication.features.auth.domain.models.LoginRequest
import com.example.myapplication.features.auth.domain.models.SignupRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/signin")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<Unit>

    @POST("auth/signup")
    suspend fun signup(
        @Body request: SignupRequest
    ):Response<Unit>
}

