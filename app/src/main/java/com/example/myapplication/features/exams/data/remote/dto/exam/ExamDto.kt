package com.example.myapplication.features.exams.data.remote.dto.exam
data class ExamDto(
    val _id: String?,
    val active: Boolean,
    val createdAt: String,
    val duration: Int?,
    val numberOfQuestions: Int,
    val subject: String,
    val title: String
)