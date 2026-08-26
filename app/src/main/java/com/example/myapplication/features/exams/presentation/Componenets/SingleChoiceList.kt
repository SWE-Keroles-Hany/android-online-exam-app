package com.example.myapplication.features.exams.presentation.Componenets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.myapplication.features.exams.domain.models.Answer

@Composable
fun SingleChoiceList(
    answers: List<Answer>,
    selectedAnswers: Map<String, Int>,
    onAnswerSelected: (Int) -> Unit,
    questionId: String,
    selectedAnswer: String,
    ) {

    LazyColumn() {
        items(answers.size) {
                index ->
            AnswerItem(
                answer = answers[index].answer,
                onClick = {
                    onAnswerSelected(index)
                } ,
                selected = index == selectedAnswers[questionId],
            )
        }
    }
}