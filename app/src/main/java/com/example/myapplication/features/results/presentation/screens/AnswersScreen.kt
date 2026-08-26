package com.example.myapplication.features.results.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.myapplication.core.sharedCompnents.CustomTopBar
import com.example.myapplication.features.exams.domain.models.Answer
import com.example.myapplication.features.exams.presentation.Componenets.SingleChoiceList
import com.example.myapplication.ui.theme.white

@Composable
fun AnswersScreen(navController: NavController)
{
    val items: List<Answer> =
    listOf(
        Answer("A1","Answer 1"),
        Answer("A2","Answer 2"),
        Answer("A3","Answer 3")
    )


    Scaffold(
        containerColor = white,
        topBar = {
            CustomTopBar(
                title = "Answers" ,
                showNavigationIcon = true ,
                navController = navController,
            )
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize()
        ){
            SingleChoiceList(
                answers = items,
                selectedAnswer ="A3",
                onAnswerSelected = {},
                selectedAnswers =  mapOf(
                    "A1" to 1,
                    "A2" to 2,
                    "A3" to 3,
                    "A4" to 3
                ),
                questionId = ""
            )
        }
    }

}

@Preview
@Composable
private fun AnswersScreenPreview() {
    AnswersScreen(navController = NavController(LocalContext.current))
}

