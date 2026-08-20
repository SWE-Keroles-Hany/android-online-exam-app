package com.example.myapplication.features.exams.presentation.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.Componenets.CustomExamItem
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsUiState
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.ui.theme.primaryColor
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExamScreenBody(
    subjectId:String? ,
    examsViewModel: ExamsViewModel = koinViewModel(),
    ) {
    LaunchedEffect(subjectId) {
        examsViewModel.getExamsBySubjectId(subjectId!!)
    }
    val uiState = examsViewModel.examsUiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.padding(22.dp).fillMaxSize()
    ) {
        when (uiState.value) {
            is ExamsUiState.Success -> {
                val items = (uiState.value as ExamsUiState.Success).exams
                if(items.isEmpty()){
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("No Exam Found",

                            style = MaterialTheme.typography.titleMedium.copy(
                                color = primaryColor
                            )
                            )
                    }
                }else{
                    LazyColumn(
                        contentPadding = PaddingValues(
                            top = 80.dp, bottom = 12.dp),
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(items) { item ->
                            CustomExamItem(
                                title = item.title,
                                minutes = item.duration,
                                from = "",
                                to = "",
                                questionsNumber = item.numberOfQuestions
                            )
                            CustomHeight(12.0)
                        }
                }


                }

            }

            is ExamsUiState.Loading -> {
                LoadingIndicator()
            }

            is ExamsUiState.Error -> {
                CustomError((uiState.value as ExamsUiState.Error).message)

            }
        }

    }

}

