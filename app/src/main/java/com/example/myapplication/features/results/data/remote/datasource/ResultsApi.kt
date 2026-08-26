package com.example.myapplication.features.results.data.remote.datasource

import com.example.myapplication.features.results.data.remote.dto.CheckAnswersRequestDto
import com.example.myapplication.features.results.data.remote.dto.CheckAnswersResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ResultsApi {
    @POST("questions/check")
    suspend fun checkAnswers(
        @Body checkAnswersRequest: CheckAnswersRequestDto
    ): Response<CheckAnswersResponseDto>

}
