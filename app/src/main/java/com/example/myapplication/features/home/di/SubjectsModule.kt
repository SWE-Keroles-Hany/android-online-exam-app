package com.example.myapplication.features.home.di
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