package com.example.myapplication.features.results.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.usecases.CheckAnswersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ReslutsViewModel(private val checkAnswersUseCase: CheckAnswersUseCase) : ViewModel()
{
    val _uiState = MutableStateFlow<ResultsUiState>(
        ResultsUiState.Loading
    )
    val uiState = _uiState.asStateFlow()
    fun checkAnswers(checkAnswersRequest: CheckAnswersRequest){
        _uiState.value = ResultsUiState.Loading
        viewModelScope.launch {

            val result = checkAnswersUseCase(
                checkAnswersRequest = checkAnswersRequest
            );

            when(result){
                is NetworkResult.Success<CheckAnswersResponse> -> {
                  val response : CheckAnswersResponse=  result.data
                    _uiState.value = ResultsUiState.Success(response)
                }
                is NetworkResult.Error -> {
                    _uiState.value = ResultsUiState.Error(result.message.toString())
                }
                else -> {
                    _uiState.value = ResultsUiState.Error("Some Thing Went Wrong")
                }
            }

        }


    }

}