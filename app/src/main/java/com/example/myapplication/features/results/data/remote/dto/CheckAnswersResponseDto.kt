package com.example.myapplication.features.results.data.remote.dto
data class CheckAnswersResponseDto(
    val WrongQuestions: List<GeneralQuestionDto>,
    val correct: Int,
    val correctQuestions: List<GeneralQuestionDto>,
    val message: String,
    val total: String,
    val wrong: Int
)