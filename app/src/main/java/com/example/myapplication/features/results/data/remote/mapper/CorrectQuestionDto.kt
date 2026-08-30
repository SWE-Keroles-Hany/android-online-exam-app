package com.example.myapplication.features.results.data.remote.mapper
import com.example.myapplication.features.exams.data.mapper.toDomain
import com.example.myapplication.features.results.data.remote.dto.CorrectQuestionDto
import com.example.myapplication.features.results.domain.models.CorrectQuestion

fun CorrectQuestionDto.toDomain(): CorrectQuestion {
   return CorrectQuestion(
        questionId = QID,
        question = Question,
        answers = answers,
        correctAnswer = correctAnswer
    )

    }