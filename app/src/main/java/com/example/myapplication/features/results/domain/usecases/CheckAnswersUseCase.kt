package com.example.myapplication.features.results.domain.usecases

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.repo.ResultsRepository

class CheckAnswersUseCase(
    private val repository: ResultsRepository
) {
    suspend operator fun invoke(checkAnswersRequest: CheckAnswersRequest): NetworkResult<CheckAnswersResponse> {
        return repository.checkAnswers(checkAnswersRequest)
    }}
