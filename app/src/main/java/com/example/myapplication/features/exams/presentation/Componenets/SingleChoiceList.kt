package com.example.myapplication.features.exams.presentation.Componenets
import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.myapplication.features.exams.domain.models.Answer

@Composable
fun SingleChoiceList(
    answers: List<Answer>,
//    selectedAnswers: Map<String, String>,
    onAnswerSelected: (String) -> Unit,
//    questionId: String,
    selectedAnswer: String,
    ) {

    LazyColumn() {
        items(answers.size) {
                index ->
            AnswerItem(
                answer = answers[index].answer,
                onClick = {
                    onAnswerSelected(answers[index].key)
                } ,
                selected = answers[index].key == selectedAnswer,
            )
        }
    }
}