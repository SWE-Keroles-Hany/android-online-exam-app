package com.example.myapplication.features.results.presentation.screens
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.GeneralQuestion
import com.example.myapplication.features.results.presentation.componenets.CustomSingleAnswerList
import com.example.myapplication.features.results.presentation.viewmodel.AnswersUiState
import com.example.myapplication.features.results.presentation.viewmodel.ResultsUiState
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import com.example.myapplication.ui.theme.error
import com.example.myapplication.ui.theme.lightGreen
import com.example.myapplication.ui.theme.lightRed
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.success
import com.example.myapplication.ui.theme.white
import com.example.myapplication.ui.theme.whiteBlue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AnswersScreen(
    navController: NavController ,
    resultsViewModel : ResultsViewModel,
    examsViewModel: ExamsViewModel,
    )
{
    val uiState =
        resultsViewModel.uiState.collectAsStateWithLifecycle()
    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                title = "Answers",
                showNavigationIcon = true,
                navController = navController,)}
    ) {
        innerPadding ->
        when(uiState.value){
            is ResultsUiState.Loading ->{
                LoadingIndicator()
            }
            is ResultsUiState.Error ->{
                CustomError((uiState.value as ResultsUiState.Error).message)
            }
            is ResultsUiState.Success -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(22.dp)
                        .padding(top = 80.dp) ,
                    verticalArrangement = Arrangement.Center
                ) {
                   val wrongQuestions = (uiState.value as ResultsUiState.Success).checkAnswersResponse.wrongQuestions
                    val correctQuestions = (uiState.value as ResultsUiState.Success).checkAnswersResponse.correctQuestions
                    val questions = wrongQuestions + correctQuestions
                    items(questions.size){
                        index ->
                        CustomSingleAnswerList(
                            questionId = questions[index].questionId,
                            resultsViewModel = resultsViewModel,
                            question = questions[index].question,
                            correctAnswer = questions[index].correctAnswer ,
                            wrongAnswer = questions[index].inCorrectAnswer,
                            // correctAnswer & inCorrectAnswer==null ==> selected is correct
                            // correctAnswer & inCorrectAnswer !=null ==> selected is inCorrect , correct is correct ansser
                        )
                    }


                }
            }

        }
    }
}