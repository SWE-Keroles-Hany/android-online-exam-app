package com.example.myapplication.features.results.data.remote.mapper
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersResponseDto
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse

fun CheckAnswersResponseDto.toDomain(): CheckAnswersResponse {
    return CheckAnswersResponse(
        wrongQuestions = WrongQuestions.map { it -> it.toDomain() },
        correct = correct,
        correctQuestions = correctQuestions.map { it -> it.toDomain() },
        message = message,
        total = total,
        wrong = wrong
    )
}
