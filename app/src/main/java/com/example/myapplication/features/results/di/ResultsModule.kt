package com.example.myapplication.features.results.di


import com.example.myapplication.features.auth.data.remote.RemoteAuthDataSource
import com.example.myapplication.features.auth.data.repository.AuthRepositoryImpl
import com.example.myapplication.features.auth.domain.repository.AuthRepository
import com.example.myapplication.features.auth.domain.usecases.LoginUseCase
import com.example.myapplication.features.auth.domain.usecases.SignupUseCase
import com.example.myapplication.features.auth.presentation.viewmodel.AuthViewModel
import com.example.myapplication.features.results.data.remote.datasource.ResultsRemoteDataSource
import com.example.myapplication.features.results.data.remote.repo.ResultsRepositoryImpl
import com.example.myapplication.features.results.domain.repo.ResultsRepository
import com.example.myapplication.features.results.domain.usecases.CheckAnswersUseCase
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val resultsModule = module {
    // Remote Data Source
    single {
        ResultsRemoteDataSource(
            answersApi = get()
        )
    }

    // Repository
    single<ResultsRepository> {
        ResultsRepositoryImpl(
            remoteDataSource = get()
        )
    }


    factory {
        CheckAnswersUseCase(
            repository = get()
        )
    }


    // ViewModel
    viewModel {
        ResultsViewModel(
            checkAnswersUseCase = get()
        )
    }

    }

