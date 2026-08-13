package com.example.myapplication.core.di

import com.example.myapplication.core.network.NetworkConstants
import com.example.myapplication.core.network.NetworkConstants.BASE_URL
import com.example.myapplication.features.auth.data.remote.AuthApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {

    single<Retrofit> {

        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    single<AuthApi> {
        get<Retrofit>().create(AuthApi::class.java)
    }
}