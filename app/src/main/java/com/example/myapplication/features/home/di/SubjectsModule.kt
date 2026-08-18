package com.example.myapplication.features.home.di

import com.example.myapplication.features.auth.data.remote.RemoteAuthDataSource
import com.example.myapplication.features.auth.data.repository.AuthRepositoryImpl
import com.example.myapplication.features.auth.domain.repository.AuthRepository
import com.example.myapplication.features.auth.domain.usecases.LoginUseCase
import com.example.myapplication.features.auth.domain.usecases.SignupUseCase
import com.example.myapplication.features.auth.presentation.viewmodel.AuthViewModel
import com.example.myapplication.features.home.data.remote.datasource.SubjectsRemoteDataSource
import com.example.myapplication.features.home.data.repo.SubjectsRepositoryImpl
import com.example.myapplication.features.home.domain.repo.SubjectsRepo
import com.example.myapplication.features.home.domain.usecases.GetAllSubjects
import com.example.myapplication.features.home.presentation.viewmodel.SubjectsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val subjectsModule = module {

    // Remote Data Source
    single {
        SubjectsRemoteDataSource(
            subjectsApi = get()
        )
    }

    // Repository
    single<SubjectsRepo> {
        SubjectsRepositoryImpl(
            remoteDataSource = get()
        )
    }

    // UseCases
    factory {
        GetAllSubjects(
            repository = get()
        )
    }


    // ViewModel
    viewModel {
        SubjectsViewModel(
           getAllSubjectsUseCase = get()
        )
    }

}