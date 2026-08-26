package com.example.myapplication.features.results.data.remote.mapper

import com.example.myapplication.features.exams.data.mapper.toDomain
import com.example.myapplication.features.results.data.remote.dto.WrongQuestionDto
import com.example.myapplication.features.results.domain.models.WrongQuestion

fun WrongQuestionDto.toDomain(): WrongQuestion {
    return WrongQuestion(
        questionId = QID,
        question = Question,
        answers = answers.map { it.toDomain() },
        correctAnswer = correctAnswer
    )

}