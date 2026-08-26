package com.example.myapplication.features.results.data.remote.dto

import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto

data class CheckAnswersRequestDto(
    val answers: List<AnswerDto>,
    val time: Int
)