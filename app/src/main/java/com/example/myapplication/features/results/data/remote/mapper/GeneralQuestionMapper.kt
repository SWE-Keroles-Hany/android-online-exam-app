package com.example.myapplication.features.results.data.remote.mapper
import com.example.myapplication.features.results.data.remote.dto.GeneralQuestionDto
import com.example.myapplication.features.results.domain.models.GeneralQuestion

fun GeneralQuestionDto.toDomain(): GeneralQuestion {
   return GeneralQuestion(
        questionId = QID,
        question = Question,
        answers = answers,
        correctAnswer = correctAnswer ,
        inCorrectAnswer = inCorrectAnswer

    )

    }