package com.example.myapplication.features.results.data.remote.dto

import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionDto

data class SingleQuestionResult(
    val message: String,
    val question:QuestionDto,
    )
