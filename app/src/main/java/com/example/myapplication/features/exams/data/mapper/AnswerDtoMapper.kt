package com.example.myapplication.features.exams.data.mapper

import com.example.myapplication.features.exams.data.remote.dto.questions.AnswerDto
import com.example.myapplication.features.exams.domain.models.Answer

fun AnswerDto.toDomain(): Answer {
    return Answer(
        answer= answer ,
        key = key
    )
}