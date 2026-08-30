package com.example.myapplication.core.di

import android.app.Application
import com.example.myapplication.features.auth.di.authModule
import com.example.myapplication.features.exams.di.examsModule
import com.example.myapplication.features.home.di.subjectsModule
import com.example.myapplication.features.results.di.resultsModule
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
                subjectsModule ,
                examsModule,
                resultsModule
            )
        }
    }
}