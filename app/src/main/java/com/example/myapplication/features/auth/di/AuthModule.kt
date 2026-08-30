package com.example.myapplication.features.auth.di

import com.example.myapplication.features.auth.data.remote.RemoteAuthDataSource
import com.example.myapplication.features.auth.data.repository.AuthRepositoryImpl
import com.example.myapplication.features.auth.domain.repository.AuthRepository
import com.example.myapplication.features.auth.domain.usecases.LoginUseCase
import com.example.myapplication.features.auth.domain.usecases.SignupUseCase
import com.example.myapplication.features.auth.presentation.viewmodel.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    // Remote Data Source
    single {
        RemoteAuthDataSource(
            authApi = get()
        )
    }

    // Repository
    single<AuthRepository> {
        AuthRepositoryImpl(
            remoteAuthDataSource = get()
        )
    }

    // UseCases
    factory {
        LoginUseCase(
            repository = get()
        )
    }
    factory {
        SignupUseCase(
            repository = get()
        )
    }


    // ViewModel
    viewModel {
        AuthViewModel(
            loginUseCase = get(),
           signupUseCase = get()
        )
    }

}