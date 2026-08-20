package com.example.myapplication.features.exams.data.mapper

import com.example.myapplication.features.exams.data.remote.dto.questions.QuestionDto
import com.example.myapplication.features.exams.domain.models.Question

fun QuestionDto.toDomain(): Question {
    return Question(
        id = id ,
        question = question ,
        answers = answers.map { it -> it.toDomain() } ,
        correct = correct ,
        type = type
    )
}
