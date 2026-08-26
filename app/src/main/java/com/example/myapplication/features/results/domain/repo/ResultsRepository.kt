package com.example.myapplication.features.results.domain.repo

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse

interface ResultsRepository {
    suspend fun checkAnswers(checkAnswersRequest: CheckAnswersRequest): NetworkResult<CheckAnswersResponse>
}