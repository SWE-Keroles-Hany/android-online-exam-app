package com.example.myapplication.core.network

import androidx.constraintlayout.core.dsl.Chain
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhODQxMjhkZDJlYTA3MjY4ZmIzMWE2ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzg3MDcyMDAxfQ.THJ3au_rpSCE5gd1B9-k-v6lZeMmVrRks_-hWyfglMU"


        val request = chain.request()
            .newBuilder()
            .apply {
                if (token.isNotEmpty()) {
                    addHeader(
                        "token",
                        token
                    )
                }
            }
            .build()

        return chain.proceed(request)
    }
}