package com.example.myapplication.core.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhODQxMjhkZDJlYTA3MjY4ZmIzMWE2ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzg4MTEyMjg4fQ.l_lJMs5MlEydIWq1hhe7Qr7Y2hzvwMMGNIlzYY3EMYQ"
        val request = chain.request()
            .newBuilder()
            .apply {
                if (token.isNotEmpty() )
                {
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