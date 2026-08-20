package com.example.myapplication.features.exams.presentation.viewmodel

import android.net.Network
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.domain.usecases.GetExamsBySubjectId
import com.example.myapplication.features.exams.domain.usecases.GetQuestionsByExamId
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ExamsViewModel(
    private  val getQuestionsByExamIdUseCase: GetQuestionsByExamId ,
    private  val getExamsBySubjectIdUseCase: GetExamsBySubjectId
) : ViewModel() {
  val _examsUiState = MutableStateFlow<ExamsUiState>(ExamsUiState.Loading)
  val _questionsUiState = MutableStateFlow<QuestionsUiState>(QuestionsUiState.Loading)

    val examsUiState = _examsUiState.asStateFlow()
    val questionsUiState =_questionsUiState.asStateFlow()

//    init {
//        getExamsBySubjectId("69d980107c82914570305dbd")
//       // getQuestionsByExamId("")
//    }

     fun getExamsBySubjectId(subjectId: String){
        viewModelScope.launch {
            _examsUiState.value = ExamsUiState.Loading
            val result = getExamsBySubjectIdUseCase(subjectId)
            when(result){
                is NetworkResult.Loading -> {
                    _examsUiState.value = ExamsUiState.Loading
                }
                is NetworkResult.Success -> {
                    _examsUiState.value = ExamsUiState.Success(result.data)

                }
                is NetworkResult.Error -> {
                    _examsUiState.value = ExamsUiState.Error(result.message?:"Some Thing Went Wrong")
                }
            }

        }

    }

     fun getQuestionsByExamId(examId:String){
        viewModelScope.launch {
            _examsUiState.value = ExamsUiState.Loading
            val result = getQuestionsByExamIdUseCase(examId)
            when(result){
                is NetworkResult.Loading -> {
                    _questionsUiState.value = QuestionsUiState.Loading
                }
                is NetworkResult.Success -> {
                    _questionsUiState.value = QuestionsUiState.Success(result.data)

                }
                is NetworkResult.Error -> {
                    _questionsUiState.value = QuestionsUiState.Error(result.message?:"Some Thing Went Wrong")
                }
            }

        }
    }


}