package com.example.myapplication.features.results.domain.models
import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto

data class GeneralQuestion(
    val questionId: String,
    val question: String,
    val answers: Map<String,String>,
    val correctAnswer: String,
    val inCorrectAnswer: String?

)
