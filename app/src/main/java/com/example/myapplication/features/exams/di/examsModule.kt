package com.example.myapplication.features.exams.di
import com.example.myapplication.features.exams.data.remote.datasource.ExamsRemoteDataSource
import com.example.myapplication.features.exams.data.repo.ExamsRepositoryImpl
import com.example.myapplication.features.exams.domain.repo.ExamsRepository
import com.example.myapplication.features.exams.domain.usecases.GetExamsBySubjectId
import com.example.myapplication.features.exams.domain.usecases.GetQuestionsByExamId
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val examsModule = module {

    // Remote Data Source
    single {
        ExamsRemoteDataSource(
            examsApi = get()
        )
    }





    // Repository
    single<ExamsRepository> {
        ExamsRepositoryImpl(
            examsRemoteDataSource = get()
        )
    }

    // UseCases
    factory {
        GetExamsBySubjectId(
            repository = get()
        )
    }
    factory {
        GetQuestionsByExamId(
            repository = get()
        )
    }

    // ViewModel
    viewModel {
        ExamsViewModel(
            getExamsBySubjectIdUseCase = get() ,
            getQuestionsByExamIdUseCase = get()
        )
    }

}