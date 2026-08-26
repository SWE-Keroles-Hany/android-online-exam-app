package com.example.myapplication.features.results.data.remote.dto

import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto

data class CorrectQuestionDto(
    val QID: String,
    val Question: String,
    val answers: List<AnswerDto>,
    val correctAnswer: String
)
