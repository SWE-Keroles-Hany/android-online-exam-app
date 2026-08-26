package com.example.myapplication.features.results.presentation.viewmodel

import com.example.myapplication.features.results.domain.models.CheckAnswersResponse

sealed interface ResultsUiState {
     data object Loading : ResultsUiState

     data class Success(
         val checkAnswersResponse: CheckAnswersResponse
     ) : ResultsUiState

     data class Error(
         val message: String
     ) : ResultsUiState
}