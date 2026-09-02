package com.example.myapplication.features.results.domain.models
data class CheckAnswersResponse(
    var wrongQuestions: List<GeneralQuestion>,
    val correct: Int,
    var correctQuestions: List<GeneralQuestion>,
    val message: String,
    val total: String,
    val wrong: Int
)