package com.example.myapplication.features.results.data.remote.mapper

import com.example.myapplication.features.results.data.remote.dto.CheckAnswersRequestDto
import com.example.myapplication.features.results.data.remote.dto.SelectedAnswerDto
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.SelectedAnswer

fun SelectedAnswer.toModel(): SelectedAnswerDto {

    return SelectedAnswerDto(
        questionId =questionId,
        correct = correct
    )
}