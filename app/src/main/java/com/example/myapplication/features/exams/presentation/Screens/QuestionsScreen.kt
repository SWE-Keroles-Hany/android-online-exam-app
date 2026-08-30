package com.example.myapplication.features.exams.presentation.Screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.presentation.Componenets.CountdownTimer
import com.example.myapplication.features.exams.presentation.Componenets.SingleChoiceList
import com.example.myapplication.features.exams.presentation.Screen.CustomDialog
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.features.exams.presentation.viewmodel.QuestionsUiState
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import com.example.myapplication.ui.theme.grey
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.white
import org.koin.compose.viewmodel.koinViewModel
import kotlin.collections.get


@Composable
fun QuestionsScreen(
    duration:Int,
    navController: NavController,
    examsViewModel : ExamsViewModel ,
    examId:String  )
{
    LaunchedEffect(Unit){
        examsViewModel.getQuestionsByExamId(examId)
    }
    var numOfQuestions by remember {
        mutableIntStateOf(1)
    }
    var showExitExamDialog by remember {
        mutableStateOf(false)
    }
    var showTimeOutDialog by remember {
        mutableStateOf(false)
    }
    var showFinishDialog by remember {
        mutableStateOf(false)
    }
    val uiState = examsViewModel.questionsUiState.collectAsStateWithLifecycle()
    var questionNumber by remember {
       mutableIntStateOf(1)
   }

    
    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                navController = navController,
                title = "Exam",
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.timer_icon),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                        CustomWidth(8.0)
                        CountdownTimer(duration)
                    }
                },
                showNavigationIcon = false,
            )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(22.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally ,
        ) {

            Text("Question $questionNumber of $numOfQuestions",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontWeight = FontWeight.W500
                ))
            CustomHeight(4.0)
            LinearProgressIndicator(
                progress = questionNumber.toFloat() / numOfQuestions,
                modifier = Modifier.fillMaxWidth(),
                primaryColor)
            CustomHeight(30.0)
            when(uiState.value){

                is QuestionsUiState.Success -> {
                    val questionWithAnswersList = (uiState.value as QuestionsUiState.Success).questionWithAnswers;
                    val question = questionWithAnswersList[questionNumber-1]
                    val answers = question.answers
                    numOfQuestions = questionWithAnswersList.size

                    Text(question.question,
                        style = MaterialTheme.typography.titleMedium
                            .copy(
                                textAlign = TextAlign.Left,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.W500,
                            ) ,
                        modifier  = Modifier.fillMaxWidth(),
                    )
                    CustomHeight(18.0)

                    SingleChoiceList(
                        answers = answers,
                        selectedAnswer =examsViewModel.answers[questionNumber-1].correct,
                        onAnswerSelected = {
                            selected ->

                            examsViewModel.selectAnswer(
                                questionNumber,
                                selected
                            )
                            Log.d("TAG","size of ${examsViewModel.answers.size}")

                        },
//
                    )
                }
                is QuestionsUiState.Error ->{
                    CustomError((uiState.value as QuestionsUiState.Error).message)
                }
                is QuestionsUiState.Loading ->{
                    LoadingIndicator()
                }
            }

            CustomHeight(24.0)
            CustomHeight(80.0)
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                CustomButton(
                    modifier= Modifier.weight(1f) ,
                    bgColor = grey , title = "Back" ,
                    titleColor = white,
                    borderColor = white,
                    onClick = {
                        if(questionNumber != 1){
                            questionNumber -= 1;

                        }
                    })
                CustomWidth(20.0)
                CustomButton(bgColor = primaryColor ,
                    titleColor = white,
                    borderColor = white,

                    modifier= Modifier.weight(1f) ,
                    title =if(questionNumber == numOfQuestions ) "Finish" else "Next",
                    onClick = {
                        if(questionNumber != numOfQuestions){
                            questionNumber += 1;
                        }else{
                            showFinishDialog = true
                        }

                    })
            }
            CustomHeight(50.0)
            CustomButton(
                modifier= Modifier.weight(1f) ,
                titleColor = white,
                borderColor = white,
                bgColor = red , title = "Exit Exam" ,
                onClick = {
                    showExitExamDialog = true

                })
           }
        if(showExitExamDialog){
            CustomDialog(
                title ="Exit For Exam",
                subTitle = "Are you sure to exit the exam",
                onConfirm = {
                    showExitExamDialog =false
                navController.popBackStack()
            } , onDismiss = {
                    showExitExamDialog =false
            })
        }
        if(showTimeOutDialog){
            CustomDialog(
                title ="Time Out",
                subTitle = "Are you sure to exit the exam",
                onConfirm = {
                    showExitExamDialog =false
                    navController.popBackStack()
                } , onDismiss = {
                    showExitExamDialog =false
                })
        }
        if(showFinishDialog){
            CustomDialog(
                title ="Submit",
                subTitle = "Are you sure to finish the exam",
                onConfirm = {
                    showFinishDialog =false
                    navController.navigate(Screen.ExamScoreScreen.route + "/${duration}")

                } , onDismiss = {
                    showFinishDialog =false
                })
        }


        }
    }


@Preview
@Composable
private fun QuestionsScreenPreview()
{
    QuestionsScreen(
        navController = NavController(LocalContext.current),
        duration = 10,
        examsViewModel = koinViewModel(),

        examId = "TODO()",
    )
}
