package com.example.myapplication.features.exams.domain.models
data class Exam(
    val examId: String?,
    val active: Boolean,
    val duration: Int?,
    val numberOfQuestions: Int,
    val subjectId: String,
    val title: String
)