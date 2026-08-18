package com.example.myapplication.core.di

import com.example.myapplication.core.network.AuthInterceptor
import com.example.myapplication.core.network.NetworkConstants
import com.example.myapplication.core.network.NetworkConstants.BASE_URL
import com.example.myapplication.features.auth.data.remote.AuthApi
import com.example.myapplication.features.home.data.remote.datasource.SubjectsApi
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<AuthInterceptor> {
        AuthInterceptor(
          //  tokenStorage = get()
        )
    }

    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(get<AuthInterceptor>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .client(get())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
    }

    single<AuthApi> {
        get<Retrofit>().create(AuthApi::class.java)
    }
    single<SubjectsApi> {
        get<Retrofit>().create(SubjectsApi::class.java)
    }
}