package com.example.myapplication.features.results.presentation.componenets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapplication.core.sharedCompnents.CustomHeight
import com.example.myapplication.features.results.presentation.viewmodel.ResultsViewModel
import com.example.myapplication.ui.theme.white
import com.example.myapplication.ui.theme.whiteBlue
import kotlin.collections.orEmpty

@Composable
fun CustomSingleAnswerList(
    question: String,
    questionId: String,
    correctAnswer : String,
    wrongAnswer : String?,
    resultsViewModel: ResultsViewModel ,
) {
    LaunchedEffect(questionId) {
        resultsViewModel.getAnswersByQuestionId(questionId)
    }
    val answers by resultsViewModel.answers.collectAsStateWithLifecycle()
    val questionAnswers = answers[questionId].orEmpty()
    Surface(
        modifier = Modifier
            .height(350.dp)
            .padding(bottom = 22.dp),
        shadowElevation = 8.dp,
        color = white,
        shape = CircleShape.copy(all = CornerSize(4)) ,
        border = BorderStroke(1.dp, whiteBlue),
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(question,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.W500 ,
                    fontSize = 18.sp,
                )
            )
            CustomHeight(10.0)
            LazyColumn(
                userScrollEnabled = false

            ) {
                items(questionAnswers.size){
                        index ->
                    CustomAnswerItem(
                        answer = questionAnswers[index],
                        wrongAnswer = wrongAnswer,
                        correctAnswer = correctAnswer
                    )
                }

            }



        }}

}
