package com.example.myapplication.features.results.domain.models
import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto
import com.example.myapplication.features.exams.domain.models.Answer

data class WrongQuestion(
    val questionId: String,
    val question: String,
    val answers: Map<String, Any>,
    val correctAnswer: String
)
