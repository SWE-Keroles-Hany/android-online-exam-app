package com.example.myapplication.features.results.data.remote.dto
data class CheckAnswersResponseDto(
    val WrongQuestions: List<WrongQuestionDto>,
    val correct: Int,
    val correctQuestions: List<CorrectQuestionDto>,
    val message: String,
    val total: String,
    val wrong: Int
)