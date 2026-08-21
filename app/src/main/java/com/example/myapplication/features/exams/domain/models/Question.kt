package com.example.myapplication.features.exams.domain.models


data class Question(
    val id: String?,
    val answers: List<Answer>,
    val correct: String,
    val question: String,
    val type: String
)