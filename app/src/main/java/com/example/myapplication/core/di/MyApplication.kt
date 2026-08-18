package com.example.myapplication.core.di

import android.app.Application
import com.example.myapplication.features.auth.di.authModule
import com.example.myapplication.features.home.di.subjectsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MyApplication)

            modules(
                networkModule,
                authModule,
                subjectsModule
            )
        }
    }
}