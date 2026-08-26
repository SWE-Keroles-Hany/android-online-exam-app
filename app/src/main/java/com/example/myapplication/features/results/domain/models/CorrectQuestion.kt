package com.example.myapplication.features.results.domain.models

import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto
import com.example.myapplication.features.exams.domain.models.Answer

data class CorrectQuestion(
    val questionId: String,
    val question: String,
    val answers: List<Answer>,
    val correctAnswer: String
)
