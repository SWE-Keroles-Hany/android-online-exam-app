package com.example.myapplication.core.network

import androidx.constraintlayout.core.dsl.Chain
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhODQxMjhkZDJlYTA3MjY4ZmIzMWE2ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzg3MjI1NTE4fQ.jC4c5Xu9jL1qBugyMVhPXtUgWUrHtc7ClIeWlfyR9_U"

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