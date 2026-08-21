package com.example.myapplication.features.exams.presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.myapplication.core.sharedCompnents.CustomButton
import com.example.myapplication.core.sharedCompnents.CustomError
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.core.sharedCompnents.CustomWidth
import com.example.myapplication.core.sharedCompnents.LoadingIndicator
import com.example.myapplication.features.exams.domain.models.Question
import com.example.myapplication.features.exams.presentation.Componenets.CountdownTimer
import com.example.myapplication.features.exams.presentation.Componenets.QuestionItem
import com.example.myapplication.features.exams.presentation.Componenets.SingleChoiceList
import com.example.myapplication.features.exams.presentation.viewmodel.ExamsViewModel
import com.example.myapplication.features.exams.presentation.viewmodel.QuestionsUiState
import com.example.myapplication.ui.theme.primaryColor
import com.example.myapplication.ui.theme.red
import com.example.myapplication.ui.theme.success
import com.example.myapplication.ui.theme.white
import com.example.myapplication.ui.theme.whiteBlue
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun QuestionsScreen(
              navController: NavController,
              examsViewModel : ExamsViewModel = koinViewModel(),
              numOfQuestions:Int, examId:String  )
{
    LaunchedEffect(Unit){
        examsViewModel.getQuestionsByExamId(examId)
    }
    val uiState = examsViewModel.questionsUiState.collectAsStateWithLifecycle()

    var questionNumber by remember {
       mutableIntStateOf(1)
   }

    var selectedAnswer:Int by remember {
        mutableIntStateOf(-1)
    }
    
    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
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
                        CountdownTimer(30)
                    }
                },
                title = "Questions" , navController = navController)
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

                    SingleChoiceList(answers,{
                        selectedAnswer = it
                    } , selectedAnswer)
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
                    bgColor = red , title = "Back" ,
                    onClick = {
                        if(questionNumber != 1){
                            questionNumber -= 1;
                            selectedAnswer = -1
                        }
                    })
                CustomWidth(20.0)
                CustomButton(bgColor = primaryColor ,
                    modifier= Modifier.weight(1f) ,
                    title = "Next" , onClick = {
                        if(questionNumber != numOfQuestions){
                            questionNumber += 1;
                           selectedAnswer = -1
                        }

                    })
            }


           }




        }
    }


//@Preview
//@Composable
//private fun QuestionsScreenPreview()
//{
//    QuestionsScreen(navController = NavController(LocalContext.current),)
//}
