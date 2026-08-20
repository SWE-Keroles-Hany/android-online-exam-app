package com.example.myapplication.features.exams.presentation.viewmodel

import com.example.myapplication.features.exams.domain.models.Exam
import com.example.myapplication.features.exams.domain.models.Question

sealed interface ExamsUiState{
    data object Loading : ExamsUiState

    data class Success(
        val exams: List<Exam>
    ) : ExamsUiState

    data class Error(
        val message: String
    ) : ExamsUiState

}

sealed interface QuestionsUiState{
    data object Loading : QuestionsUiState

    data class Success(
        val exams: List<Question>
    ) : QuestionsUiState

    data class Error(
        val message: String
    ) : QuestionsUiState

}