package com.example.myapplication.features.results.data.remote.dto
import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto

data class GeneralQuestionDto(
    val QID: String,
    val Question: String,
    val answers: Map<String,String>,
    val correctAnswer: String,
    val inCorrectAnswer: String?

)
