package com.example.myapplication.features.results.domain.models

data class CheckAnswersResponse(
    val wrongQuestions: List<WrongQuestion>,
    val correct: Int,
    val correctQuestions: List<CorrectQuestion>,
    val message: String,
    val total: String,
    val wrong: Int
)