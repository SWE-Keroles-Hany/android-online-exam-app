package com.example.myapplication.features.results.domain.models
import com.example.myapplication.features.exams.domain.models.Answer

data class CheckAnswersRequest(
    val answers: List<SelectedAnswer>,
    val time: Int
)