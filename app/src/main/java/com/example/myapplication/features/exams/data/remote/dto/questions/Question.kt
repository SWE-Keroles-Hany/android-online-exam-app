package com.example.myapplication.features.exams.data.remote.dto.questions
data class QuestionDto(
    val _id: String,
    val answers: List<AnswerDto>,
    val correct: String,
    val createdAt: String,
    val exam: Any,
    val question: String,
    val subject: Any,
    val type: String
)