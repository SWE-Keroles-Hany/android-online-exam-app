package com.example.myapplication.features.results.data.remote.mapper

import com.example.myapplication.features.exams.data.mapper.toModel
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersRequestDto
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest

fun CheckAnswersRequest.toModel(): CheckAnswersRequestDto {

    return CheckAnswersRequestDto(
        answers =answers.map { it.toModel() },
        time = time
    )
}