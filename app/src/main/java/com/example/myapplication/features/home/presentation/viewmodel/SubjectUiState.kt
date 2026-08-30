package com.example.myapplication.features.home.presentation.viewmodel
import com.example.myapplication.features.home.domain.models.Subject

sealed interface SubjectUiState {

    data object Loading : SubjectUiState

    data class Success(
        val subjects: List<Subject>
    ) : SubjectUiState

    data class Error(
        val message: String
    ) : SubjectUiState
}