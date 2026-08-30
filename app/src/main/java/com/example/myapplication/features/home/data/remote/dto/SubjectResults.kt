package com.example.myapplication.features.home.data.remote.dto

import kotlin.Metadata
import com.example.myapplication.features.home.data.remote.dto.Metadata as Metadata1

data class SubjectResults(
    val message: String,
    val metadata: Metadata1,
    val subjects: List<SubjectDto>
)