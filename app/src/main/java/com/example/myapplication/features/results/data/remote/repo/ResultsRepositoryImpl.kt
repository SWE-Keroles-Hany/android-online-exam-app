package com.example.myapplication.features.results.data.remote.repo

import com.example.myapplication.core.network.NetworkResult
import com.example.myapplication.features.results.data.remote.datasource.ResultsRemoteDataSource
import com.example.myapplication.features.results.data.remote.mapper.toDomain
import com.example.myapplication.features.results.data.remote.mapper.toModel
import com.example.myapplication.features.results.domain.models.CheckAnswersRequest
import com.example.myapplication.features.results.domain.models.CheckAnswersResponse
import com.example.myapplication.features.results.domain.repo.ResultsRepository

class ResultsRepositoryImpl(
    private val remoteDataSource: ResultsRemoteDataSource
): ResultsRepository {
    override suspend fun checkAnswers(checkAnswersRequest: CheckAnswersRequest): NetworkResult<CheckAnswersResponse> {
        return try {
            val response = remoteDataSource.checkAnswers(checkAnswersRequest.toModel())
            if (response is NetworkResult.Success) {
                NetworkResult.Success(response.data.toDomain())
            } else if(response is NetworkResult.Error){
                NetworkResult.Error(response.message)
            } else {
                NetworkResult.Error("Some Thing Went Wrong")
            }
        }catch (e:Exception){
            NetworkResult.Error(e.message)
        }
    }
}