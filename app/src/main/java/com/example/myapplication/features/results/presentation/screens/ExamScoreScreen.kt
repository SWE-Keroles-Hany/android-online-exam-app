package com.example.myapplication.features.results.presentation.screens
import android.R.attr.duration
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.SelectedAnswer
import com.example.myapplication.features.results.presentation.componenets.CorrectAndInCorrectInfo
import com.example.myapplication.features.results.presentation.componenets.CustomCircleProgress
import com.example.myapplication.features.results.presentation.viewmodel.ResultsUiState
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.white
import org.koin.compose.viewmodel.koinViewModel

@SuppressLint("DefaultLocale")
@Composable
fun ExamScoreScreen(
    examsViewModel: ExamsViewModel,
    navController: NavController,
    resultsViewModel: ResultsViewModel = koinViewModel(),
    time: Int ,
    ) {
    val uiState  = resultsViewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        resultsViewModel.checkAnswers(
            request = CheckAnswersRequest(
                answers =examsViewModel.answers ,
                time = time))

      //  examsViewModel.clearAnswers()
    }


    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                showNavigationIcon = false ,
                navController = navController,
                title = "Exam Score"
            )
        },
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(22.dp)
                .fillMaxSize()
        ) {
            Text("Your Score" , style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.Bold ,
            ))
                when(uiState.value){
                    is ResultsUiState.Success -> {
                        val response = uiState.value as ResultsUiState.Success
                        val checkAnswerResults = response.checkAnswersResponse



                        Row(
                            Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            // correct - total / 10
                            val correct = checkAnswerResults.correct
                            val total = examsViewModel.answers.size

                            CustomCircleProgress(
                                percentage = "${String.format("%.1f" ,(correct.toFloat()/total.toFloat())*100)}%",
                                progress= (correct.toFloat()/total.toFloat())
                            )

                            CorrectAndInCorrectInfo(
                                correct =checkAnswerResults.correct ,
                                inCorrect = checkAnswerResults.wrong
                            )
                        }

                    }
                    is ResultsUiState.Loading -> {
                        CircularProgressIndicator()

                    }
                    is ResultsUiState.Error -> {
                        Text((uiState.value as ResultsUiState.Error).message , color = red)

                    }



                }

            CustomHeight(80.0)
            CustomButton(
                bgColor = primaryColor ,
                onClick = {
                    navController.navigate(Screen.AnswersScreen.route)

                } ,
                title = "Show Results",
                borderColor = white ,
                titleColor = white ,
            )
            CustomHeight(20.0)
            CustomButton(
                bgColor = white ,
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                } ,
                title = "Back To Subjects" ,
                borderColor = primaryColor,
                titleColor = primaryColor,
            )
        }
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//private fun ExamScoreScreenPreview() {
//    ExamScoreScreen(
//        navController = NavController(LocalContext.current),
//        answers = emptyList(),
//        time = 10
//    )
//}
