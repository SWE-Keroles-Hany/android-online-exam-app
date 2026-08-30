package com.example.myapplication.features.results.presentation.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.models.SelectedAnswer
import com.example.myapplication.features.results.domain.usecases.CheckAnswersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultsViewModel(private val checkAnswersUseCase: CheckAnswersUseCase) : ViewModel()
{
    private var _answers =
        mutableStateListOf<CheckAnswersResponse>()
    var answers = _answers
    val _uiState = MutableStateFlow<ResultsUiState>(
        ResultsUiState.Loading
    )
    val uiState = _uiState.asStateFlow()

    fun checkAnswers(request: CheckAnswersRequest) {

        viewModelScope.launch {


            _uiState.value = ResultsUiState.Loading

            try {

                when (val result = checkAnswersUseCase(request)) {
                    is NetworkResult.Success -> {

                        _uiState.value =
                            ResultsUiState.Success(result.data)
                    }

                    is NetworkResult.Error -> {

                        _uiState.value =
                            ResultsUiState.Error(
                                result.message.toString()
                            )
                    }

                    is NetworkResult.Loading -> {
                        _uiState.value = ResultsUiState.Loading
                    }
                }

            } catch (e: Exception) {

                Log.e("RESULT", "EXCEPTION", e)

                _uiState.value =
                    ResultsUiState.Error(
                        e.message ?: "Unknown error"
                    )
            }
        }
    }


}