package com.example.myapplication.core.network

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token ="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjZhODQxMjhkZDJlYTA3MjY4ZmIzMWE2ZSIsInJvbGUiOiJ1c2VyIiwiaWF0IjoxNzg4MjU0NDYyfQ.6EwdtBnMvyMe39hlsryVmDCw3b9dN8RXEZ918eIpZyU"
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