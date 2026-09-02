package com.example.myapplication.features.results.presentation.viewmodel
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.models.GeneralQuestion
import com.example.myapplication.features.results.domain.models.SelectedAnswer
import com.example.myapplication.features.results.domain.usecases.CheckAnswersUseCase
import com.example.myapplication.features.results.domain.usecases.GetAnswersByQuestionIdUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ResultsViewModel(
    private val checkAnswersUseCase: CheckAnswersUseCase ,
    private val getAnswersByQuestionIdUseCase: GetAnswersByQuestionIdUseCase
    ) : ViewModel()
{


    private val _answers = MutableStateFlow<Map<String, List<Answer>>>(emptyMap())
    val answers = _answers.asStateFlow()
    val _uiState = MutableStateFlow<ResultsUiState>(
        ResultsUiState.Loading
    )
    val _answersUiState = MutableStateFlow<AnswersUiState>(
        AnswersUiState.Loading
    )
    val answersUiState = _answersUiState.asStateFlow()
    val uiState = _uiState.asStateFlow()

    fun checkAnswers(request: CheckAnswersRequest) {

        viewModelScope.launch {


            _uiState.value = ResultsUiState.Loading

            try {

                when (val result = checkAnswersUseCase(request)) {
                    is NetworkResult.Success -> {
                        Log.d("TAG","wrongQuestions size in vModel: ${result.data.wrongQuestions.size}")

                        Log.d("TAG","correctQuestions size in vModel: ${result.data.correctQuestions.size}")
                        _uiState.value =
                            ResultsUiState.Success(CheckAnswersResponse(
                                wrongQuestions = result.data.wrongQuestions,
                                correct = result.data.correct,
                                correctQuestions = result.data.correctQuestions,
                                message = result.data.message,
                                total = result.data.total,
                                wrong = result.data.wrong
                            ))
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


    fun getAnswersByQuestionId(questionId: String) {

        viewModelScope.launch {
            _answersUiState.value = AnswersUiState.Loading
            try {

                when (val result = getAnswersByQuestionIdUseCase(questionId)) {
                    is NetworkResult.Success -> {
                        _answers.update { current ->
                            current + (questionId to result.data)
                        }
                    }

                    is NetworkResult.Error -> {
                        _answersUiState.value =
                            AnswersUiState.Error(
                                result.message.toString()
                            )
                    }

                    is NetworkResult.Loading -> {
                        _answersUiState.value = AnswersUiState.Loading
                    }
                }

            } catch (e: Exception) {

                Log.e("RESULT", "EXCEPTION", e)

                _answersUiState.value =
                    AnswersUiState.Error(
                        e.message ?: "Unknown error"
                    )
            }
        }
    }



}