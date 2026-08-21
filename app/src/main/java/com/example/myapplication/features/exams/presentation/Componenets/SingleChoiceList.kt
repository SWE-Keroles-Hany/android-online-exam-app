package com.example.myapplication.features.exams.presentation.Componenets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.myapplication.features.exams.domain.models.Answer

@Composable
fun SingleChoiceList(answers: List<Answer>,  onAnswerSelected: (Int) -> Unit ,selectedAnswer:Int) {

    LazyColumn() {
        items(answers.size) {
                item ->
            QuestionItem(
                question = answers[item].answer,
                onClick = {
                    onAnswerSelected(item)
                } ,
                selected = item == selectedAnswer,
            )
        }
    }
}