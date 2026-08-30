package com.example.myapplication.features.exams.data.remote.dto.exam
data class ExamResults(
    val exams: List<ExamDto>,
    val message: String,
    val metadata: Metadata
)