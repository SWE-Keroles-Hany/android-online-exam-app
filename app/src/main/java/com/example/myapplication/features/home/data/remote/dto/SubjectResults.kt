package com.example.myapplication.features.home.data.remote.dto

data class SubjectResults(
    val message: String,
    val metadata: Metadata,
    val subjects: List<SubjectDto>
)