package com.example.myapplication.features.exams.presentation.Componenets
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsUiState
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.ui.theme.primaryColor
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ExamScreenBody(
    subjectId:String? ,
    navController: NavController,
    examsViewModel: ExamsViewModel,
    ) {
    LaunchedEffect(subjectId) {
        examsViewModel.getExamsBySubjectId(subjectId?:"")

    }
    val uiState = examsViewModel.examsUiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.padding(22.dp).fillMaxSize()
    ) {
        when (uiState.value) {
            is ExamsUiState.Success -> {
                val exams = (uiState.value as ExamsUiState.Success).exams
                if( exams.isEmpty() )
                {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center ,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text("No Exam Found", style = MaterialTheme.typography.titleMedium.copy(color = primaryColor))
                    }
                }else{
                    LazyColumn(
                        contentPadding = PaddingValues(
                            top = 80.dp, bottom = 12.dp),
                        modifier = Modifier.fillMaxWidth().weight(1f)
                    ) {
                        items(exams.size) {
                            index ->
                            CustomExamItem(
                                onClick = {
              navController.navigate(Screen.ExamInstructionsScreen.route + "/${exams[index].title}/${exams[index].duration}/${exams[index].numberOfQuestions}/${exams[index].examId}")
                                },
                                title = exams[index].title,
                                minutes = exams[index].duration,
                                from = "",
                                to = "",
                                questionsNumber = exams[index].numberOfQuestions
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

