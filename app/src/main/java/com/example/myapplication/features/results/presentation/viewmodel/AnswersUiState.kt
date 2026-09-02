package com.example.myapplication.features.results.presentation.viewmodel

import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse

sealed interface AnswersUiState {
    data object Loading : AnswersUiState

    data class Success(
        val answers: List<Answer>
    ) : AnswersUiState

    data class Error(
        val message: String
    ) : AnswersUiState
}