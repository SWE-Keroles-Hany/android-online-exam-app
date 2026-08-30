package com.example.myapplication.features.home.presentation.viewmodel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.home.domain.models.Subject
import com.example.myapplication.features.home.domain.usecases.GetAllSubjects
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SubjectsViewModel (private  val getAllSubjectsUseCase: GetAllSubjects) : ViewModel() {

    private val _uiState = MutableStateFlow<SubjectUiState>(
        SubjectUiState.Loading
    )

    val uiState : StateFlow<SubjectUiState> = _uiState.asStateFlow() ;
    init {
        getAllSubjects()
    }
    fun getAllSubjects(){

        viewModelScope.launch {
            _uiState.value = SubjectUiState.Loading ;
            val result = getAllSubjectsUseCase() ;
           when(result){
               is NetworkResult.Success<List<Subject>> -> {
                   _uiState.value = SubjectUiState.Success(result.data)
               }
               is NetworkResult.Error -> {
                   _uiState.value = SubjectUiState.Error(result.message?:"Some Thing Went Wrong")
               }

               else -> {
                   _uiState.value = SubjectUiState.Loading
               }
           }


        }
    }

}
