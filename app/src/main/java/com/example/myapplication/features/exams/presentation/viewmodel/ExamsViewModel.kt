package com.example.myapplication.features.exams.presentation.viewmodel
import android.util.Log
import android.util.Log.i
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.exams.domain.usecases.GetExamsBySubjectId
import com.example.myapplication.features.exams.domain.usecases.GetQuestionsByExamId
import com.example.myapplication.features.results.domain.models.SelectedAnswer
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

    private val _answers = mutableStateListOf<SelectedAnswer>()
    val answers: List<SelectedAnswer>
        get() = _answers
    fun clearAnswers() {
        _answers.clear()
    }
    fun initializeAnswers(questions: List<Question>) {
        clearAnswers()

        questions.forEach { question ->
            _answers.add(
                SelectedAnswer(
                    questionId = question.id.toString(),
                    correct = ""
                )
            )
        }
    }
    fun selectAnswer(
        questionNumber: Int,
        selectedAnswer: String
    ) {
        _answers[questionNumber - 1] =
            _answers[questionNumber - 1].copy(
                correct = selectedAnswer
            )
    }
     fun getExamsBySubjectId(subjectId: String){
        viewModelScope.launch {
            _examsUiState.value = ExamsUiState.Loading
            when(val result = getExamsBySubjectIdUseCase(subjectId)){
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
            when(val result = getQuestionsByExamIdUseCase(examId)){
                is NetworkResult.Loading -> {
                    _questionsUiState.value = QuestionsUiState.Loading

                }
                is NetworkResult.Success -> {
                    Log.d("TAG","size res${result.data}")
                    val questions:List<Question>  = result.data
                    _questionsUiState.value = QuestionsUiState.Success(result.data)
                    initializeAnswers(result.data)

                }
                is NetworkResult.Error -> {
                    _questionsUiState.value = QuestionsUiState.Error(result.message?:"Some Thing Went Wrong")
                }
            }

        }
    }


}